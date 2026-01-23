package com.shaper.CashFlow.Services;

import com.shaper.CashFlow.Models.UserModel;
import com.shaper.CashFlow.Repositories.UsersRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor

public class UsersServices {
    @Autowired
    private UsersRepo usersRepo;

    public List<UserModel> getAllUsers(){
        return  this.usersRepo.findAll();
    }

    public UserModel getUserById(Long id){
        return this.usersRepo.findById(id).orElseThrow(() -> new RuntimeException("The user("+id+") doesn't Exist"));
    }

    // I use optional to avoid Nullable Exception
    public UserModel getUserByEmail(String email){
            return this.usersRepo.email(email).orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    public UserModel addUser(UserModel user){
        return this.usersRepo.save(user);
    }


}
