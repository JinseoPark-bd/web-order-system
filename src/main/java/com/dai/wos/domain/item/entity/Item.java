package com.dai.wos.domain.item.entity;

import com.dai.wos.baseEntity.BaseEntity;
import com.dai.wos.domain.category.entity.Category;
import com.dai.wos.domain.owner.entity.Owner;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID", nullable = false)
    private Owner owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATE_ID",nullable = false)
    private Category category;

    @Column(nullable = false)
    private int itemCount;

}
