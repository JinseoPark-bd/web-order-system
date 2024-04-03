package com.dai.wos.domain.cart.entity;

import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="CART_SEQ_GENERATOR", sequenceName = "CART_SEQ", initialValue = 1, allocationSize = 50)
@Entity(name = "OJT_OMS_CART_JPA")
public class Cart {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SEQ_GENERATOR")
    private Long cartId;

    //주인이 아니면 mappedBy 속성으로 주인 선정
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID",nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID",nullable = false)
    private Item item;

    @Column(nullable = false)
    private int itemCount;
}