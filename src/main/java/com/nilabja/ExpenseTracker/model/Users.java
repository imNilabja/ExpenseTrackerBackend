package com.nilabja.ExpenseTracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class Users {

    @Id
    @Column(name = "user_name")   // PK column in DB
    private String userName;

    @Column(name = "user_email")  // matches DB column
    private String userEmail;

    @Column(name = "user_password")  // matches DB column
    private String userPassword;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
