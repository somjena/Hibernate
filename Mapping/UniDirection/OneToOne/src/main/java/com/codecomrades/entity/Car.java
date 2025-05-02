package com.codecomrades.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Car {
    @Id
    private int Car_id;
    private String Car_name;
    private int price;
    @OneToOne
    private Engine engine;

    public int getCar_id() {
        return Car_id;
    }

    public void setCar_id(int car_id) {
        Car_id = car_id;
    }

    public String getCar_name() {
        return Car_name;
    }

    public void setCar_name(String car_name) {
        Car_name = car_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
