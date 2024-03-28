package com.dai.wos.domain.user.entity;

import com.dai.wos.baseEntity.BaseEntity;
import com.dai.wos.domain.owner.entity.Owner;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OJT_OMS_USER_JPA")
public class User extends BaseEntity {

    @Id
    private String userId;

    @Column(nullable = false)
    private String userPwd;

    private String userNm;

    private char userGroup;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    private String userTel;

    private String userEmail;

    @Column(nullable = false)
    private char userUse;

}
