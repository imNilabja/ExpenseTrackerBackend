package com.nilabja.ExpenseTracker.model;

import jakarta.persistence.*;

@Entity
@Table(name="stuff_table")

public class StuffItem implements ExpenseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stuff_id;
    @ManyToOne
    @JoinColumn(name = "month_id")
    private Month month;
    private String itemName;
    private double itemCost;
    final private String category="stuff";


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

    public long getStuff_id() {
        return stuff_id;
    }

    public void setStuff_id(long stuff_id) {
        this.stuff_id = stuff_id;
    }
}
