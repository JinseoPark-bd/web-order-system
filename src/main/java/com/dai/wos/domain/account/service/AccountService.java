package com.dai.wos.domain.account.service;

import com.dai.wos.domain.account.entity.Account;
import com.dai.wos.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findByActId(String actId) {
        return accountRepository.findById(actId).orElseThrow();
    }
}
