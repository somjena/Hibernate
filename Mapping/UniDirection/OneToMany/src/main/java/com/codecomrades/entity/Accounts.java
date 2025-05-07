package com.codecomrades.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Accounts {
    @Id
    private int ac_no;
    private String ac_Name;
    private int ac_balance;

    public int getAc_no() {
        return ac_no;
    }

    public void setAc_no(int ac_no) {
        this.ac_no = ac_no;
    }

    public String getAc_Name() {
        return ac_Name;
    }

    public void setAc_Name(String ac_Name) {
        this.ac_Name = ac_Name;
    }

    public int getAc_balance() {
        return ac_balance;
    }

    public void setAc_balance(int ac_balance) {
        this.ac_balance = ac_balance;
    }
}