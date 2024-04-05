package com.dai.wos.domain.cart.entity;

import com.dai.wos.baseEntity.BaseEntity;
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
@Entity(name = "OJT_OMS_CATE_ITEM")
public class CartItem extends BaseEntity {

    @Id
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

    @Builder
    public CartItem(Cart cart, Item item, int quantity) {
        this.cart = cart;
        this.item = item;
        this.quantity = quantity;
    }
}
