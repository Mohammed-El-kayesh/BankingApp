package com.SpringProject.BankingApp.mapper;

import com.SpringProject.BankingApp.dto.AccountDto;
import com.SpringProject.BankingApp.model.Account;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(
                accountDto.getId(),
                accountDto.getAccountOwner(),
                accountDto.getBalance()
        );
    }

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getAccountOwner(),
                account.getBalance()
        );
    }
}
