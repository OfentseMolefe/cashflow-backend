package com.shaper.CashFlow.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Users")
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    //This Mapping complements the usage of cascade to delete the transactions
    // belonging to the Current user
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore   //This annotation helps to avoid/stop Infinite Recursion(During Api calling)
    private List<TransactionModel> transactions = new ArrayList<>();



    private LocalDateTime create_at = LocalDateTime.now(); // to get the current date and time stamp

}
