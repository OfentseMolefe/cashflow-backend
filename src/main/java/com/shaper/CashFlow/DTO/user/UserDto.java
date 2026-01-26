package com.shaper.CashFlow.DTO.user;

import com.shaper.CashFlow.Models.TransactionModel;
import com.shaper.CashFlow.Models.UserModel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
public class UserDto {

    //========Request DTO=========//
    /*
     * Create New User Request
     * */

    @Data
    public static class CreateRequest{
        //@NoBlank(message = "Email is required")
        private String email;
        private String password;

        //clean email
        public String getCleanEmail(){
            return email  != null ? email.trim().toLowerCase() :null;
        }
    }

    // For update the user
    @Data
    public static class UpdateRequest{
        private  String email,password;

        public boolean hasUpdates(){
            return(email !=null && !email.trim().isEmpty() || (password != null && !password.trim().isEmpty()));
        }
    }

    // for login  request
    @Data
    public static class LoginRequest{
        private String email,password;
    }

    ///==========Responses ============//
    //Basic user Response ( without password)
    @Data
    public static class BasicResponse{
        private Long id;
        private String email;
        private LocalDateTime created_at;
    }

    //User response with transactions

    @Data
    public static class WithTransactionResponse{
        private Long id;
        private String email;
        private LocalDateTime created_at;
        private List<TransactionModel> transactions = new ArrayList<>();  // Use the transaction dto
    }


    //====== Mappers / Helper Methods =========//
    /*
     *  Convert the UserModel to BasicResponse
     * */
    public static  BasicResponse toBasicResponse (UserModel user){
        BasicResponse dto = new BasicResponse();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setCreated_at(user.getCreate_at());

        return  dto;
    }


    /*
     * Convert UserModel to WithTransactionsResponse
     * */
    public static  WithTransactionResponse toWithTransaction (UserModel user){
        WithTransactionResponse dto = new WithTransactionResponse();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setCreated_at(user.getCreate_at());
        dto.setTransactions(user.getTransactions());

        return  dto;
    }
}
