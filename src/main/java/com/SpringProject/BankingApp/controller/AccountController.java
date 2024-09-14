package com.SpringProject.BankingApp.controller;

import com.SpringProject.BankingApp.dto.AccountDto;
import com.SpringProject.BankingApp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController
{
private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
@PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
    {
        System.out.println(accountDto); // Print the incoming DTO

        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable long id)
    {
        try {
            AccountDto accountDto = accountService.getAccountById(id);
            return ResponseEntity.ok(accountDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<?> deposit(@PathVariable long id, @RequestBody Map<String,Double> request)
    {
        try {
            Double amount=request.get("amount");
            AccountDto accountDto=  accountService.deposite(id,amount);
            return ResponseEntity.ok(accountDto);
        }catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<?> withdraw(@PathVariable long id,@RequestBody Map<String,Double> request)
    {
        try {
            double amount=request.get("amount");
            AccountDto accountDto=accountService.withdraw(id,amount);
            return ResponseEntity.ok(accountDto);
        }catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts()
    {
      List<AccountDto> accounts=  accountService.getAllAccounts();
      return ResponseEntity.ok(accounts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable long id)
    {
       try{
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted successfully!");
    } catch (RuntimeException e)
       {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }

    }
}
