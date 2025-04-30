package com.codecomrades.controller;

import com.codecomrades.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class StudentDriver {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction et;
    private static Scanner sc;

    public static void main(String[] args) {
         emf=Persistence.createEntityManagerFactory("HNA");
         em =emf.createEntityManager();
         et=em.getTransaction();
         sc=new Scanner(System.in);
         boolean flag = true;
         while(flag){
             System.out.println("1.save\n2.delete\n3.update\n4.edit\n5.exit");
             int choice=sc.nextInt();
             switch (choice){
                 case 1:save();
             }
         }





    }

    private static void save() {
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
