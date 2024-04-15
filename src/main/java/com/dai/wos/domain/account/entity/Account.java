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
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OJT_OMS_ACCOUNT_JPA")
public class Account extends BaseEntity {

    @Id
    @Column(length = 25)
    private String accountId;

    @Column(nullable = false, length = 100)
    private String accountNm;

    @Column(nullable = false, length = 3)
    private String zipCd;

    @Column(nullable = false)
    private String addr1;

    private String addr2;

    @Column(length = 25)
    private String accountTel;

    @Column(length = 25)
    private String accountMng;

    @Column(nullable = false, length = 10)
    private String taxNo;

    @Builder
    private Account(String accountId, String accountNm, String zipCd, String addr1, String taxNo) {
        this.accountId = accountId;
        this.accountNm = accountNm;
        this.zipCd = zipCd;
        this.addr1 = addr1;
        this.taxNo = taxNo;
    }

}
