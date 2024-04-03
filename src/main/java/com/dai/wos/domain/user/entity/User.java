package com.dai.wos.domain.user.entity;

import com.dai.wos.baseEntity.BaseEntity;
import com.dai.wos.domain.owner.entity.Owner;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "OJT_OMS_USER")
public class User extends BaseEntity {

    @Id
    private String userId;

    @Column(nullable = false)
    private String userPwd;

    @Column(nullable = false)
    private String userNm;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserGroup userGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID" ,nullable = false)
    private Owner owner;

    private String userTel;

    private String userEmail;

    @Column(nullable = false)
    private char userUse;

    private String roles;

    @Builder
    private User (String userId, String userPwd, String userNm, UserGroup userGroup, Owner owner, String userTel, String userEmail) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userNm = userNm;
        this.userGroup = userGroup;
        this.owner = owner;
        this.userTel = userTel;
        this.userEmail = userEmail;
        this.userUse = 'y';
    }

}
