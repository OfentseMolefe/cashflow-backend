package com.shaper.CashFlow.Services;

import com.shaper.CashFlow.DTO.user.UserDto;
import com.shaper.CashFlow.Models.UserModel;
import com.shaper.CashFlow.Repositories.UsersRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsersServices {

    private final UsersRepo usersRepo;
    private final PasswordEncoder passwordEncoder;

    //get all users
    public List<UserDto.BasicResponse> getAllUsers(){
        return  usersRepo.findAll()
                .stream()
                .map(UserDto::toBasicResponse)
                .collect(Collectors.toList());
    }

    // Get user by ID
    public UserDto.BasicResponse getUserById(Long id){
        UserModel user = this.usersRepo.findById(id).
                orElseThrow(() -> new RuntimeException("The user("+id+") doesn't Exist"));
        return UserDto.toBasicResponse(user);
    }

    // I use optional to avoid Nullable Exception
    public UserDto.WithTransactionResponse getUserByEmail(String email){
             String cleanEmail = email.trim().toLowerCase();
             UserModel user = UsersRepo.email(cleanEmail).orElseThrow(() -> new RuntimeException("NOT FOUND"));
            return  UserDto.toWithTransaction(user);
    }


    // Create a user
   @Transactional
    public UserDto.BasicResponse addUser(UserDto.CreateRequest request){
        //check if the email exist
        String cleanEmail = request.getCleanEmail();
        if(UsersRepo.email(cleanEmail).isPresent()){
            throw  new RuntimeException("Email already exists");
        }

        //Create the user and save
        UserModel user = new UserModel();
        user.setEmail(cleanEmail);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return  UserDto.toBasicResponse(usersRepo.save(user));
    }

    // Delete user
    @Transactional
    public void deleteUser(Long id) {
        if (!usersRepo.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        usersRepo.deleteById(id);
    }

    //Login
    public UserDto.BasicResponse login(UserDto.LoginRequest request){
        String cleanEmail = request.getEmail().trim().toLowerCase();
        UserModel user = UsersRepo.email(cleanEmail).
                orElseThrow(() -> new RuntimeException("Invalid credentails"));

        //check the corresponding password
        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid credentails");
        }
        /*
        * For future Reference After the authentication create a token for the user *
        *  */
        return UserDto.toBasicResponse(user);
    }


}
