package com.shaper.CashFlow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Transactions")
@Setter
@Getter
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    private LocalDateTime transactionDate = LocalDateTime.now(); //changed to be same name as a DTO

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private  CategoryModel category;

    private LocalDateTime created_at = LocalDateTime.now();

}
