package com.dai.wos.domain.user.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 인증 정보 저장 DTO 클래스
 */
@Data
public class LoginDto {
    @NotNull(message = "ID cannot be null")
    @Size(min = 5, message = "ID not be less than 5 characters")
    private String id;

    @NotNull(message = "Password cannot be null")
    @Size(min = 4, message = "Password must be equals or grater than 4 characters")
    private String password;
}
