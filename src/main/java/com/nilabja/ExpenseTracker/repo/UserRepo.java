package com.nilabja.ExpenseTracker.repo;

import com.nilabja.ExpenseTracker.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,String> {
    boolean existsByUserName(String userName);
    boolean existsByUserPassword(String userPassword);


}
