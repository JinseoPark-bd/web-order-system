package com.dai.wos.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.support.BeanDefinitionDsl;

@Getter
@AllArgsConstructor
public enum UserRole {
    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

    private final String role;

    public static String getIncludingRole(String role) {
        return UserRole.valueOf(role).getRole();
    }
}
