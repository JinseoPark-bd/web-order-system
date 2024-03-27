package com.dai.wos.domain.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

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

    private String actId;

    private String actNm;

    private String itemId;

    private String itemNm;

    private String ownerId;

    @Column(nullable = false)
    private int ordCnt;

    private String unit;
}
