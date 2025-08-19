package com.codecomrades.Driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class CarDriver {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction et;
    private static Scanner sc;

    static {
       emf=Persistence.createEntityManagerFactory("OneToOneBi");
       em=emf.createEntityManager();
       et=em.getTransaction();
    }

    public static void main(String[] args) {
        System.out.println("1.Save\n2.Delete\n3.Update\n4.SearchById\n5.findAll");
        boolean choice = true;
        while(true){
            switch (choice){

            }
        }



    }
}
