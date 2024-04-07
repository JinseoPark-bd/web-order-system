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
    @Column(length = 50)
    private String actId;

    @Column(nullable = false, length = 200)
    private String actNm;

    @Column(nullable = false, length = 6)
    private String zipCd;

    @Column(nullable = false)
    private String addr1;

    private String addr2;

    @Column(length = 50)
    private String actTel;

    @Column(length = 50)
    private String actMng;

    @Column(nullable = false, length = 20)
    private String taxNo;

}
