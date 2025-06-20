package com.codecomrades.Entity;

import jakarta.persistence.*;

@Entity
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int e_id;
    private String e_type;
    private int e_cc;
    @OneToOne(cascade = CascadeType.ALL )
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_type() {
        return e_type;
    }

    public void setE_type(String e_type) {
        this.e_type = e_type;
    }

    public int getE_cc() {
        return e_cc;
    }

    public void setE_cc(int e_cc) {
        this.e_cc = e_cc;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "e_id=" + e_id +
                ", e_type='" + e_type + '\'' +
                ", e_cc=" + e_cc +
                ", car=" + car +
                '}';
    }
}
