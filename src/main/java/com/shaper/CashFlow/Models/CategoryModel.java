package com.shaper.CashFlow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Categories")
//@Data  // Fix this to get the better security
@Setter
@Getter
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String Type;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserModel user;
}
