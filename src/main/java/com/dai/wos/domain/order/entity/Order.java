package com.dai.wos.domain.order.entity;

import com.dai.wos.domain.account.entity.Account;
import com.dai.wos.domain.item.entity.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OJT_OMS_ORDER_JPA")
public class Order {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String seq;

    private String orderkey;

    @ManyToOne
    @JoinColumn(name = "ACT_ID")
    private Account account;

    //private String actNm;

    @OneToMany
    @JoinColumn(name="ORDER_SEQ")
    private List<Item> items = new ArrayList<>();

    //private String itemNm;

    @ManyToOne
    @JoinColumn(name="ORDER_SEQ")
    private String ownerId;

    @Column(nullable = false)
    private int ordCnt;

    private String unit;
}
