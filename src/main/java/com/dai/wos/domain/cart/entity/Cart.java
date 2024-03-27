package com.dai.wos.domain.cart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private String userId;

    private String itemId;

    private int itemCount;
}