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
@Entity(name = "OJT_OMS_CART_JPA")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String cartId;

    //주인이 아니면 mappedBy 속성으로 주인 선정
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private User userId;

    @OneToMany
    @JoinColumn(name = "CART_ID")
    private List<Item> items = new ArrayList<>();

    private int itemCount;
}