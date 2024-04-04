package com.dai.wos.domain.auth.controller;

import com.dai.wos.domain.user.controller.dto.LoginDto;
import com.dai.wos.domain.user.entity.User;
import com.dai.wos.domain.user.repository.UserRepository;
import com.dai.wos.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @PostMapping("/api/login")
    public String authenticateAndGetToken(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getId(),
                        loginDto.getPassword()
                ));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(loginDto.getId());
        } else {
            throw new UsernameNotFoundException("아이디가 존재하지 않습니다.");
        }
    }

    @PostMapping("/api/new")
    public String addNewUser(@RequestBody LoginDto loginDto) {
        loginDto.setPassword(
                passwordEncoder.encode(loginDto.getPassword()));
        User savedUserInfo = User.builder()
                .userId(loginDto.getId())
                .userPwd(loginDto.getPassword())
                .userEmail(loginDto.getId()+"@donga.co.kr")
                .userNm("박진서")
                .userTel("010-1234-5678")
                .build();

        userRepository.save(savedUserInfo);

        return savedUserInfo.getUserNm() + " 님 환영합니다";
    }


}
