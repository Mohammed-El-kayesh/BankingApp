package com.SpringProject.BankingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name="accounts")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="accountOwner")
    private String accountOwner;
    private double balance;


}
