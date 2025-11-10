package com.nilabja.ExpenseTracker.model;


import org.springframework.stereotype.Component;


public interface ExpenseItem {
   double getItemCost();
   String getItemName();
}
