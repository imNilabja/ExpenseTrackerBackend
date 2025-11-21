package com.nilabja.ExpenseTracker.repo;

import com.nilabja.ExpenseTracker.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem,Long> {
    List<FoodItem> findByMonth_MonthId(Long monthId);
    List<FoodItem> findByMonth_MonthIdAndUser(Long monthId,String userName);


}
