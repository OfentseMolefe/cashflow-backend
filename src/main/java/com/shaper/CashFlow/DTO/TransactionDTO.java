package com.shaper.CashFlow.DTO;

import java.time.LocalDateTime;

public class TransactionDTO {
        private Long id;
        private double amount;
        private String description;
        private String category;
        private LocalDateTime transactionDate;
        private LocalDateTime created_at;
    }

