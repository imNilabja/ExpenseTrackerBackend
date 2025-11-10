package com.nilabja.ExpenseTracker.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name ="year_table")

public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long year_id;

    private int year;


    public long getYear_id() {
        return year_id;
    }

    public void setYear_id(long year_id) {
        this.year_id = year_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
