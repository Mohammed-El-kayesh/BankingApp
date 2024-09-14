package com.SpringProject.BankingApp.implementation;

import com.SpringProject.BankingApp.dto.AccountDto;
import com.SpringProject.BankingApp.mapper.AccountMapper;
import com.SpringProject.BankingApp.model.Account;
import com.SpringProject.BankingApp.repository.AccountRepository;
import com.SpringProject.BankingApp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService
{
    private AccountRepository accountRepository;
      Account account=new Account();
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }



    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount= accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);    }

    @Override
    public AccountDto getAccountById(long id) {
       Account account=  accountRepository
               .findById(id)
               .orElseThrow(()->new RuntimeException("Account does not exist"));

   return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposite(long id, double amount) {
        Account account=  accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));
        double total = account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount= accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
    @Override
    public AccountDto withdraw(long id, double amount) {
        Account account=  accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));
if (account.getBalance() < amount)
{
    throw new RuntimeException("Insufficient amount");

}
double total=account.getBalance()-amount;
account.setBalance(total);
Account savedAccount= accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
       List<Account> accounts= accountRepository.findAll();
      return accounts.stream().map((account)->
               AccountMapper.mapToAccountDto(account))
               .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(long id) {
        Account account=  accountRepository
                .findById(id)
                .orElseThrow(()->
                        new RuntimeException("Account does not exist"));


        accountRepository.deleteById(id);

    }

}
