package com.dai.wos.domain.item.entity;

import com.dai.wos.baseEntity.BaseEntity;
import com.dai.wos.domain.category.entity.Category;
import com.dai.wos.domain.owner.entity.Owner;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OJT_OMS_ITEM_JPA")
public class Item extends BaseEntity {
    @Id
    @Column(length = 25)
    private String itemId;

    @Column(nullable = false, length = 100)
    private String itemNm;

    @Column(length = 100)
    private String itemEnNm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID", nullable = false)
    private Owner owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID",nullable = false)
    private Category category;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, length = 5)
    private String unit;

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void subQuantity (int quantity) {
        this.quantity -= quantity;
    }

    @Builder
    private Item(String itemId, String itemNm, Owner owner, Category category, int quantity, String unit) {
        this.itemId = itemId;
        this.itemNm = itemNm;
        this.owner = owner;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
    }

}
