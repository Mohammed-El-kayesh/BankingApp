package com.SpringProject.BankingApp.service;

import com.SpringProject.BankingApp.dto.AccountDto;

import java.util.List;

public interface AccountService
{
AccountDto createAccount(AccountDto accountDto);

AccountDto getAccountById(long id);
AccountDto deposite(long id,double amount);
AccountDto withdraw(long id,double amount);

List<AccountDto> getAllAccounts();

void deleteAccount(long id);
}
