package com.codecomrades.Driver;

import com.codecomrades.entity.Product;
import com.codecomrades.entity.Reviews;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class User {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToOne");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et  = em.getTransaction();
        Product p1 = new Product();
        p1.setP_id(1);
        p1.setP_name("Nike Shoes");
        p1.setP_price(2699);


        Reviews r1 = new Reviews();
        r1.setR_id(121);
        r1.setTitle("Very Good Product");
        r1.setProduct(p1);


        et.begin();
        em.persist(p1);
        em.persist(r1);
        et.commit();



    }
}
