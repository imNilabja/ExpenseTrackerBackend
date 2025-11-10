package com.nilabja.ExpenseTracker.repo;

import com.nilabja.ExpenseTracker.model.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface YearRepo extends JpaRepository<Year,Long> {

    Optional<Year> findByYear(int year);

}
