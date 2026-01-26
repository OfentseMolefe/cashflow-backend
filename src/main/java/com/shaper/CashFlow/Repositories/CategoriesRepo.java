package com.shaper.CashFlow.Repositories;

import com.shaper.CashFlow.Models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepo extends JpaRepository<CategoryModel,Long> {
}
