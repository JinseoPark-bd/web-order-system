package com.dai.wos.domain.owner.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OJT_OMS_OWNER_JPA")
public class Owner {

    @Id
    private String ownerId;

    private String ownerNm;

    private String ceoNm;

    private String ownerTel;

    private String ownerFax;
}
