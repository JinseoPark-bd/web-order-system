package com.dai.wos.domain.account.controller;

import com.dai.wos.domain.account.controller.dto.AccountResponseDto;
import com.dai.wos.domain.account.entity.Account;
import com.dai.wos.domain.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    // 거래처 코드로 검색
    @GetMapping("/api/accounts")
    public AccountResponseDto findById(@RequestParam String actId) {
        return AccountResponseDto.toDto(accountService.findByActId(actId));
    }

    // 거래처 리스트 불러오기
    @GetMapping("/api/accounts")
    public List<AccountResponseDto> findAll() {
        List<Account> accounts = accountService.findAll();

        return accounts.stream()
                .map(account -> AccountResponseDto.toDto(account))
                .collect(Collectors.toList());
    }


}
