package com.dai.wos.domain.cart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OJT_OMS_CART_JPA")
public class Cart {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String cartId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="")
    private String userId;

    @OneToMany
    @JoinColumn(name="CART_ID")
    private String itemId;

    private int itemCount;
}