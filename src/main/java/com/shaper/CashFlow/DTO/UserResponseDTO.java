package com.shaper.CashFlow.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public  class UserResponseDTO{
    private Long id;
    private String email;
    private LocalDateTime create_at;
    private List<TransactionDTO> transactions = new ArrayList<>(); //Don't forget to include TRANSACTION DTO instated of model
}
