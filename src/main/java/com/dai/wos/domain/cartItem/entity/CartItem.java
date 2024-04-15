package com.dai.wos.domain.cartItem.entity;

import com.dai.wos.baseEntity.BaseEntity;
import com.dai.wos.domain.cart.entity.Cart;
import com.dai.wos.domain.item.entity.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name="CART_ITEM_ID_GENERATOR",
        sequenceName = "CART_ITEM_SEQ",
        initialValue = 1, allocationSize = 1)
@Entity(name = "OJT_OMS_CART_ITEM_JPA")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_ITEM_ID_GENERATOR")
    private Long cartItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CART_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Item item;

    @Column(nullable = false)
    private int quantity;

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }


    @Builder
    public CartItem(Cart cart, Item item, int quantity) {
        this.cart = cart;
        this.item = item;
        this.quantity = quantity;
    }

}
