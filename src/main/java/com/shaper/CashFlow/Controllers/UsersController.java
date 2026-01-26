package com.shaper.CashFlow.Controllers;

import com.shaper.CashFlow.Models.UserModel;
import com.shaper.CashFlow.Services.UsersServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")

public class UsersController {

    @Autowired
     private final UsersServices usersServices;

    public UsersController(UsersServices usersServices) {
        this.usersServices = usersServices;
    }

    @GetMapping()
    public List<UserModel> getAllUsers(){
         return  this.usersServices.getAllUsers();
     }

     @GetMapping("/{id}")
     public UserModel getUserByID(@PathVariable Long id){
         return this.usersServices.getUserById(id);
     }

     @GetMapping("/email")
     public  UserModel getUserByEmail(@RequestParam String email){
         return this.usersServices.getUserByEmail(email);
    }

     @PostMapping
    public UserModel  addUser(@RequestBody UserModel user){
         return  this.usersServices.addUser(user);
     }

}
