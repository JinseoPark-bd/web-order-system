package com.dai.wos.domain.owner.entity;

import com.dai.wos.baseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OJT_OMS_OWNER_JPA")
public class Owner extends BaseEntity {

    @Id
    @Column(length = 50)
    private String ownerId;

    @Column(nullable = false, length = 200)
    private String ownerNm;

    @Column(length = 50)
    private String ceoNm;

    @Column(length = 40)
    private String ownerTel;

    @Column(length = 20)
    private String ownerFax;

    @Builder
    private Owner(String ownerId, String ownerNm) {
        this.ownerId = ownerId;
        this.ownerNm = ownerNm;
    }
}
