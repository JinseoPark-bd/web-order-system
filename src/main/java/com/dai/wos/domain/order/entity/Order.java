package com.dai.wos.domain.order.entity;

import com.dai.wos.domain.account.entity.Account;
import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.owner.entity.Owner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OJT_OMS_ORDER_JPA")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long seq;

    @ManyToOne
    @JoinColumn(name = "ACT_ID")
    private Account account;

    @Column(nullable = false)
    private String actNm;

    @OneToOne
    @JoinColumn(name="ITEM_ID")
    private Item item;

    @Column(nullable = false)
    private String itemNm;

    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    private Owner owner;

    @Column(nullable = false)
    private int ordCnt;

    @Column(nullable = false)
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
