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
    @Column(length = 30)
    private String userId;

    @Column(nullable = false, length = 20)
    private String userPwd;

    @Column(nullable = false, length = 50)
    private String userNm;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID" ,nullable = false)
    private Owner owner;

    @Column(length = 40)
    private String userTel;

    @Column(length = 100)
    private String userEmail;

    @Column(nullable = false)
    private char userUse;


    @Builder
    private User (String userId, String userPwd, String userNm, String userTel, String userEmail, UserRole userRole, Owner owner) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userNm = userNm;
        this.userRole = userRole;
        this.owner = owner;
        this.userTel = userTel;
        this.userEmail = userEmail;
        this.userUse = 'y';
    }

}
