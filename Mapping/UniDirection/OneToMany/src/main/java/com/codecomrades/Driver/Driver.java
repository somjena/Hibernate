package com.codecomrades.Driver;

import com.codecomrades.entity.Accounts;
import com.codecomrades.entity.Bank;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnetoMany");
        EntityManager em =emf.createEntityManager();
        EntityTransaction et = em.getTransaction();


        Bank b1 = new Bank();
        b1.setB_id(1);
        b1.setB_name("SBI");
        b1.setIfsc("SBIN0001801");


        Accounts a1 = new Accounts();
        a1.setAc_no(220);
        a1.setAc_Name("Som jena");
        a1.setAc_balance(92300);

        Accounts a2 = new Accounts();
        a2.setAc_no(230);
        a2.setAc_Name("Subdhir barik");
        a2.setAc_balance(300);


        b1.addac(a1);
        b1.addac(a2);

        et.begin();
        em.persist(b1);
        em.persist(a1);
        em.persist(a2);
        et.commit();


       }





}
