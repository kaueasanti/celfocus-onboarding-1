package com.training.springbootbuyitem.service;

import com.training.springbootbuyitem.entity.model.Item;

public interface IItemService extends ICrudService<Item> {

	void restock(Long id, Integer quantity);

	void dispatch(Long id, Integer quantity);

	void block(Long id, Integer quantity);

}
