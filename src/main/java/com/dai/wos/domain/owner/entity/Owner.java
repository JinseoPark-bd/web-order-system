package com.dai.wos.domain.owner.entity;

import jakarta.persistence.Column;
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
    @Column(length = 50)
    private String owner_id;

    @Column(nullable = false, length = 200)
    private String ownerNm;

    @Column(length = 50)
    private String ceoNm;

    @Column(length = 40)
    private String ownerTel;

    @Column(length = 20)
    private String ownerFax;
}
