package com.dai.wos.domain.order.entity;

import com.dai.wos.baseEntity.BaseEntity;
import com.dai.wos.domain.account.entity.Account;
import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.owner.entity.Owner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OJT_OMS_ORDER_JPA")
public class Order extends BaseEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID",nullable = false)
    private Account account;

    @Column(nullable = false, length = 200)
    private String accountNm;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "ITEM_ID",nullable = false)
    private Item item;

    @Column(nullable = false, length = 200)
    private String itemNm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID",nullable = false)
    private Owner owner;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, length = 10)
    private String unit;

    @Builder
    private Order (Account account, Item item, Owner owner, int quantity) {
        this.account = account;
        this.accountNm = account.getAccountNm();
        this.item = item;
        this.itemNm = item.getItemNm();
        this.owner = owner;
        this.quantity = quantity;
        this.unit = item.getUnit();
    }
}
