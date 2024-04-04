package com.dai.wos.domain.auth.service;

import com.dai.wos.domain.user.controller.dto.LoginDto;
import com.dai.wos.domain.user.entity.User;
import com.dai.wos.domain.user.repository.UserRepository;
import com.dai.wos.security.jwt.JwtService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class AuthService {
//    private final UserRepository userRepository;
//    private final JwtService jwtService;
//    private final ModelMapper modelMapper;
//
//    public String login(LoginDto dto) throws Exception {
//        String userId = dto.getId();
//        String password = dto.getPassword();
//        Optional<User> user = userRepository.findById(userId);
//        user.orElseThrow(() -> new UsernameNotFoundException("아이디가 존재하지 않습니다."));
//
//    }
}
