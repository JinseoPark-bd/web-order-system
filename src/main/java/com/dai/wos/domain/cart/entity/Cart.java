package com.dai.wos.domain.cart.entity;

import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name="CART_ID_GENERATOR",
        sequenceName = "CART_SEQ",
        initialValue = 1, allocationSize = 1)
@Entity(name = "OJT_OMS_CART_JPA")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_ID_GENERATOR")
    private Long cartId;

    //주인이 아니면 mappedBy 속성으로 주인 선정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Builder
    public Cart(User user) {
        this.user = user;
    }
}