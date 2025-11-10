package com.nilabja.ExpenseTracker.repo;

import com.nilabja.ExpenseTracker.model.Month;
import com.nilabja.ExpenseTracker.model.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonthRepo extends JpaRepository<Month,Long>{
    Optional<Month> findByMonthAndYearId(String month, long yearId);

}
