package com.nilabja.ExpenseTracker.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name ="month_table")
public class Month {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long monthId;

    private long yearId;  // ✅ renamed from year_id to yearId

    private String month;

    public long getMonthId() {
        return monthId;
    }

    public void setMonthId(long monthId) {
        this.monthId = monthId;
    }

    public long getYearId() {
        return yearId;
    }

    public void setYearId(long yearId) {
        this.yearId = yearId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
