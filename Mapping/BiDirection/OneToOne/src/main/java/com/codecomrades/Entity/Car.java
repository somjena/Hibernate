package com.codecomrades.Entity;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int c_id;
    private String c_name;
    private int c_price;
    @OneToOne(cascade = CascadeType.ALL)
    private Engine engine;

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getC_price() {
        return c_price;
    }

    public void setC_price(int c_price) {
        this.c_price = c_price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", c_price=" + c_price +
                ", engine=" + engine +
                '}';
    }
}
