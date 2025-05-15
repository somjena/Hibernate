package com.codecomrades.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Driver {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction et;
    private static Scanner sc ;
    static {
        emf= Persistence.createEntityManagerFactory("ManyToMany");
        em= emf.createEntityManager();
        et= em.getTransaction();
    }
    public static void main(String[] args) {
    }
}
