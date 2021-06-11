package com.training.springbootbuyitem.service;

import com.training.springbootbuyitem.entity.model.Item;
import com.training.springbootbuyitem.enums.EnumEntity;
import com.training.springbootbuyitem.enums.EnumItemState;
import com.training.springbootbuyitem.error.EntityNotFoundException;
import com.training.springbootbuyitem.error.NullObjectException;
import com.training.springbootbuyitem.error.StockNotAvailableException;
import com.training.springbootbuyitem.repository.ItemRepository;
import com.training.springbootbuyitem.utils.properties.ItemStorageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemStorageProperties itemStorageProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Item> list() {
        return itemRepository.findAll();
    }

    @Cacheable("buy")
    @Override
    public Item get(Long id) {
        return itemRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(EnumEntity.ITEM.name(), id));
    }

    @Cacheable("buy")
    @Override
    public List<Item> get(List<Long> id) {
        return new ArrayList<>();
    }

    @Override
    public void delete(Long id) {
        itemRepository.delete(get(id));
    }


    @Override
    public Item update(Item item) {
        Item persistedItem = get(item.getItemUid());
        if (!StringUtils.isEmpty(item.getName())) {
            persistedItem.setName(item.getName());
        }
        if (!StringUtils.isEmpty(item.getDescription())) {
            persistedItem.setDescription(item.getDescription());
        }
        if (!StringUtils.isEmpty(item.getMarket())) {
            persistedItem.setMarket(item.getMarket());
        }
        if (item.getStock() != null && item.getStock().intValue() >= 0) {
            persistedItem.setStock(item.getStock());
        }
        if (item.getPriceTag() != null && item.getPriceTag().longValue() >= 0.0) {
            persistedItem.setPriceTag(item.getPriceTag());
        }
        return itemRepository.save(persistedItem);
    }

    @Override
    public Item save(Item item) {
        if (item != null) {
            item.setState(EnumItemState.AVAILABLE.name());
            return itemRepository.save(item);
        }
        throw new NullObjectException();
    }

    @Override
    public void restock(Long id, Integer quantity) {
        Item item = get(id);
        item.setStock(item.getStock().add(BigInteger.valueOf(quantity)));
        item.setState(EnumItemState.AVAILABLE.name());
        save(item);
    }

    @Override
    public void dispatch(Long id, Integer quantity) {
        Item item = get(id);
        checkItemAvailability(item, quantity);
        item.setStock(item.getStock().subtract(BigInteger.valueOf(quantity)));
        item.setReservedStock(item.getStock().subtract(BigInteger.valueOf(quantity)));
        save(item);
        if (item.getStock().compareTo(BigInteger.valueOf(quantity)) == 0) {
            item.setState(EnumItemState.RESTOCK.name());
        }
    }

    private void checkItemAvailability(Item item, Integer quantity) {
        if (item.getStock().compareTo(BigInteger.valueOf(quantity)) < 0) {
            throw new StockNotAvailableException(item.getName());
        }
    }

    @Override
    public void block(Long id, Integer quantity) {
        Item item = get(id);
        checkItemAvailability(item, quantity);
        item.setStock(item.getStock().subtract(BigInteger.valueOf(quantity)));
        item.setReservedStock(item.getReservedStock().add(BigInteger.valueOf(quantity)));
        save(item);
    }
}
