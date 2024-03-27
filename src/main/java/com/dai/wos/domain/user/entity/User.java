package com.dai.wos.domain.user.entity;

import com.dai.wos.baseEntity.BaseEntity;
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

    private String ownerId;

    private String userTel;

    private String userEmail;

    @Column(nullable = false)
    private char userUse;

}
