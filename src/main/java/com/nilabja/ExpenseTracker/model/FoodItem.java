package com.nilabja.ExpenseTracker.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="food_table")
public class FoodItem implements ExpenseItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long food_id;



    @ManyToOne
    @JoinColumn(name = "month_id")
    private Month month;
    private String itemName;
    private double itemCost;
    final private String category="food";


    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }


    @Override
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    @Override
    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public long getFood_id() {
        return food_id;
    }

    public void setFood_id(long food_id) {
        this.food_id = food_id;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "food_id=" + food_id +
                ", month=" + month +
                ", itemName='" + itemName + '\'' +
                ", itemCost=" + itemCost +
                '}';
    }
}
