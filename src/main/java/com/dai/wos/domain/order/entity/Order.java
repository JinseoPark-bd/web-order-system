package com.dai.wos.domain.order.entity;

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
public class Order {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACT_ID",nullable = false)
    private Account account;

    @Column(nullable = false, length = 200)
    private String actNm;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "ITEM_ID",nullable = false)
    private Item item;

    @Column(nullable = false, length = 200)
    private String itemNm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID",nullable = false)
    private Owner owner;

    @Column(nullable = false)
    private int ordCnt;

    @Column(nullable = false, length = 10)
    private String unit;

    @Builder
    private Order (Account account, Item item, Owner owner, int ordCnt, String unit) {
        this.account = account;
        this.actNm = account.getActNm();
        this.item = item;
        this.itemNm = item.getItemNm();
        this.owner = owner;
        this.ordCnt = ordCnt;
        this.unit = unit;
    }
}
