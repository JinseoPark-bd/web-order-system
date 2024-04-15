package com.dai.wos.domain.account.service;

import com.dai.wos.domain.account.entity.Account;
import com.dai.wos.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {
    private final AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(String accountId) {
        return accountRepository.findById(accountId).orElseThrow();
    }

    public List<Account> findByKeyword (String keyword) {
        return accountRepository.findByKeyword(keyword);
    }
}
