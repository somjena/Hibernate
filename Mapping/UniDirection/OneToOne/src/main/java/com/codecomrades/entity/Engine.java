package com.codecomrades.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Engine {
    @Id
    private int Engine_Id;
    private String Type;
    private int Cc;


    public int getEngine_Id() {
        return Engine_Id;
    }

    public void setEngine_Id(int engine_Id) {
        Engine_Id = engine_Id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getCc() {
        return Cc;
    }

    public void setCc(int cc) {
        Cc = cc;
    }
}
