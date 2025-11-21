package com.nilabja.ExpenseTracker.repo;

import com.nilabja.ExpenseTracker.model.FoodItem;
import com.nilabja.ExpenseTracker.model.StuffItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StuffRepo extends JpaRepository<StuffItem,Long> {
    List<StuffItem> findByMonth_MonthId(Long monthId);
    List<StuffItem> findByMonth_MonthIdAndUser(Long monthId, String userName);

}
