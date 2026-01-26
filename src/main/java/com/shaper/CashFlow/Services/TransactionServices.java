package com.shaper.CashFlow.Services;

import com.shaper.CashFlow.Repositories.TransactionRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class TransactionServices {

    @Autowired
    private TransactionRepo transactionRepo;

    //Get all transactions
    public Object allTransaction(){
        return transactionRepo.findAll();
    }

}
