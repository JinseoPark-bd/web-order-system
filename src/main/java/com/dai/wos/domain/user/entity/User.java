package com.dai.wos.domain.user.entity;

import com.dai.wos.baseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    private String loginId;

    private String password;

    private

}
