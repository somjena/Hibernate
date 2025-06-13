package com.codecomrades.Driver;

import com.codecomrades.Entity.Car;
import com.codecomrades.Entity.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CarDriver {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction et;
    static {
        emf = Persistence.createEntityManagerFactory("OneToOneBi");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setC_id(2);
        car1.setC_name("Alto");
        car1.setC_price(499355);

        Engine e1 = new Engine();
        e1.setCar(car1);
        e1.setE_id(102);
        e1.setE_type("Petrol");
        e1.setE_cc(1200);

        car1.setEngine(e1);


        et.begin();
        em.persist(car1);
        System.out.println("Data Saved");
        et.commit();


    }
}
