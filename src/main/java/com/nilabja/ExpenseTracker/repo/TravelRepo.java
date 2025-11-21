package com.nilabja.ExpenseTracker.repo;

import com.nilabja.ExpenseTracker.model.FoodItem;
import com.nilabja.ExpenseTracker.model.TravelItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepo extends JpaRepository<TravelItem,Long> {
    List<TravelItem> findByMonth_MonthId(Long monthId);
    List<TravelItem> findByMonth_MonthIdAndUser(Long monthId, String userName);

}
