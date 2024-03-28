package com.dai.wos.domain.user.service;

import com.dai.wos.domain.user.controller.dto.UserLoginRequestDto;

public interface UserService {
    public String login(UserLoginRequestDto requestDto) throws Exception;
}
