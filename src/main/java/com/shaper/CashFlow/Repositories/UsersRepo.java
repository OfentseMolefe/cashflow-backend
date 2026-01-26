package com.shaper.CashFlow.Repositories;

import com.shaper.CashFlow.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<UserModel, Long> {
    static Optional<UserModel> email(String email) {
        return Optional.empty();
    }
}
