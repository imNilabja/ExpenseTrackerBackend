package com.nilabja.ExpenseTracker.repo;

import com.nilabja.ExpenseTracker.model.MescItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MescRepo extends JpaRepository<MescItem,Long> {
    List<MescItem> findByMonth_MonthId(Long monthId);

}
