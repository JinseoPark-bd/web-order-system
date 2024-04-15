package com.dai.wos.domain.account.controller;

import com.dai.wos.domain.account.controller.dto.AccountResponseDto;
import com.dai.wos.domain.account.entity.Account;
import com.dai.wos.domain.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;

    // 거래처 코드로 검색
    @GetMapping("/{actId}")
    public AccountResponseDto findById(@PathVariable String accountId) {
        return AccountResponseDto.toDto(accountService.findById(accountId));
    }

    // 거래처 ID OR 거래처 이름으로 검색
    @GetMapping("/search")
    public List<AccountResponseDto> findByKeyword(@RequestParam String keyword) {
        return accountService.findByKeyword(keyword).stream()
                .map(account -> AccountResponseDto.toDto(account))
                .collect(Collectors.toList());
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
