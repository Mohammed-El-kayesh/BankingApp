package com.SpringProject.BankingApp.dto;



public class AccountDto
{
    private long id;
    private String accountOwner;
    private double balance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountDto() {
    }

    public AccountDto(long id, String accountOwner, double balance) {
        this.id = id;
        this.accountOwner = accountOwner;
        this.balance = balance;
    }
}
