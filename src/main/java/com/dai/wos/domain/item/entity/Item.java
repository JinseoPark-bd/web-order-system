package com.dai.wos.domain.item.entity;

import com.dai.wos.baseEntity.BaseEntity;
import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    private String ownerId;

    @ManyToOne
    @JoinColumn(name="CATE_ID")
    private String cateId;

    private int itemCount;

}
