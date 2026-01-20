package com.shaper.CashFlow.Repositories;

import com.shaper.CashFlow.Models.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionModel, Long> {
}
