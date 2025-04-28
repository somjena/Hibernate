package com.codecomrades.controller;

import com.codecomrades.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class StudentDriver {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("HNA");
        EntityManager em =emf.createEntityManager();
        EntityTransaction et =em.getTransaction();
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student();
        System.out.println("Enter the id you Want");
        s1.setSid(sc.nextInt());
        System.out.println("Enter the Name");
        sc.nextLine();
        s1.setSname(sc.nextLine());
        System.out.println("Enter the Age");
        s1.setSage(sc.nextInt());
        System.out.println("Enter the Mark");
        s1.setMark(sc.nextInt());
        et.begin();
        em.persist(s1);
        et.commit();
        System.out.println("Data Saved");


    }
}
