package com.nilabja.ExpenseTracker.model;

import jakarta.persistence.*;


@Entity
@Table(name="travel_table")

public class TravelItem implements ExpenseItem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long travel_id;
    @ManyToOne
    @JoinColumn(name = "month_id")
    private Month month;
    private String itemName;
    private double itemCost;
    final private String category="travel";


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

    public long getTravel_id() {
        return travel_id;
    }

    public void setTravel_id(long travel_id) {
        this.travel_id = travel_id;
    }
}
