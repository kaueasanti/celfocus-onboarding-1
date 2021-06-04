package com.training.springbootbuyitem.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Proxy(lazy = false)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userUid;
    @Column(unique = true)
    private String name;
    private String email;
    private String password;
    public String cart;
    private BigDecimal credit;
    @OneToMany(mappedBy = "user")
    private Map<Long, CartItem> cartItems = new HashMap<>();

    public User(String name){
        this.name = name;
    }

    public void addOrUpdateItemToCart(Item item, Long quantity) {
        CartItem cartItem;
        if (cartItems.containsKey(item.getItemUid())) {
            cartItem = cartItems.get(item.getItemUid());
            cartItem.setQuantity(quantity);
        } else {
            cartItem = new CartItem(quantity, item);
        }
        cartItems.put(item.getItemUid(), cartItem);
    }

    public void removeItemFromCart (Item item) {
        cartItems.remove(item.getItemUid());
    }

}
