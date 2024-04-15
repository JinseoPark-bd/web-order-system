package com.dai.wos.domain.account.controller.dto;

import com.dai.wos.domain.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDto {
    private String accountId;
    private String accountNm;
    private String addr;

    public static AccountResponseDto toDto(Account account) {
        return new AccountResponseDto(
                account.getAccountId(),
                account.getAccountNm(),
                account.getAddr1() + " " + account.getAddr2());
    }
}
