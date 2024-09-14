package com.SpringProject.BankingApp.repository;

import com.SpringProject.BankingApp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long>
{
}
