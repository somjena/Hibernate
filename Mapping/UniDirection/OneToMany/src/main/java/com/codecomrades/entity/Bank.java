package com.codecomrades.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {
    @Id
    private int B_id;
    private String B_name;
    private String Ifsc;
    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name = "bank_id"),inverseJoinColumns = @JoinColumn(name = "Ac_id"))
    private List<Accounts>accountsList= new ArrayList<>();
    public void addac(Accounts accounts){
        accountsList.add(accounts);
    }

    public int getB_id() {
        return B_id;
    }

    public void setB_id(int b_id) {
        B_id = b_id;
    }

    public String getB_name() {
        return B_name;
    }

    public void setB_name(String b_name) {
        B_name = b_name;
    }

    public String getIfsc() {
        return Ifsc;
    }

    public void setIfsc(String ifsc) {
        Ifsc = ifsc;
    }

    public List<Accounts> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<Accounts> accountsList) {
        this.accountsList = accountsList;
    }
}
