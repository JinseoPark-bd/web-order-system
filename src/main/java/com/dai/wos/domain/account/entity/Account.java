package com.dai.wos.domain.account.entity;

import com.dai.wos.baseEntity.BaseEntity;
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
@Entity(name = "OJT_OMS_ACT_JPA")
public class Account extends BaseEntity {

    @Id
    private String actId;

    @Column(nullable = false)
    private String actNm;

    @Column(nullable = false)
    private String actEnNm;

    @Column(nullable = false)
    private char actGroup;

    @Column(nullable = false)
    private String zipCd;

    @Column(nullable = false)
    private String addr1;

    private String addr2;

    private String actTel;

    private String actManager;

    private String taxNo;

}
