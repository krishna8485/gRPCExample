package com.betPawa.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name= "UserEURWallet")
public class UserEURWallet {


    private double amount;



    public UserEURWallet() {

    };

    public UserEURWallet(String userID, double amount) {
        this.userID = userID;
        this.amount = amount;

    };

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userID;


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }


}
