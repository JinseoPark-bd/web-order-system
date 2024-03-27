package com.dai.wos.domain.item.entity;

import com.dai.wos.baseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OJT_OMS_ITEM_JPA")
public class Item extends BaseEntity {
    @Id
    private String itemId;

    @Column(nullable = false)
    private String itemNm;

    private String ownerId;

    private String cateId;

    private int itemCount;

}
