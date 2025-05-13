package com.codecomrades.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Subjects {
    @Id
    private int sub_id;
    private String sub_name;
    private int sub_duration;

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public int getSub_duration() {
        return sub_duration;
    }

    public void setSub_duration(int sub_duration) {
        this.sub_duration = sub_duration;
    }
}
