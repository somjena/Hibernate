package com.codecomrades.controller;

import com.codecomrades.entity.Car;
import com.codecomrades.entity.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CarDriver {
    public static void main(String[] args) {
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("OnetoOne");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Car c1 = new Car();
        c1.setCar_id(1);
        c1.setCar_name("Fortuner");
        c1.setPrice(4950000);
        Engine e1 = new Engine();
        e1.setEngine_Id(101);
        e1.setType("Diesel");
        e1.setCc(2500);
        c1.setEngine(e1);

        et.begin();
        em.persist(c1);
        em.persist(e1);
        et.commit();
        System.out.println("Data Saved !!!!");


    }
}
