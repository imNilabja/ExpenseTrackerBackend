package com.nilabja.ExpenseTracker.model;

import jakarta.persistence.*;

@Entity
@Table(name="mesc_table")

public class MescItem implements ExpenseItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mesc_id;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "month_id")
    private Month month;
    @Column(name="user_id")
    private String user;
    private String itemName;
    private double itemCost;
    final private String category="mesc";


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

    public long getMesc_id() {
        return mesc_id;
    }

    public void setMesc_id(long mesc_id) {
        this.mesc_id = mesc_id;
    }

    @Override
    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

}
