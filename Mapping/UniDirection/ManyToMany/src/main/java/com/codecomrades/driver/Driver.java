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
        sc=new Scanner(System.in);
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Many To Many Mapping Example::__::");
        boolean flag = true;
        while(flag){
            System.out.println("Enter the Option U want to Perform");
            System.out.println("1.Add Student\n2.Add Subject\n3.Add SubjectForStudent\n4.Delete SubjectforStudent\n5.Update Student\n6.Update Subject\n7.Exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:addstudent();
                break;
                case 2:addSubject();
                break;
                case 3:AddSubjectforStudent();
                break;
                case 4:DeleteSubjectForStudent();
                break;
                case 5:UpdateStudent();
                
            }
        }
    }

    private static void UpdateStudent() {
    }

    private static void DeleteSubjectForStudent() {
    }

    private static void AddSubjectforStudent() {
    }

    private static void addSubject() {
    }

    private static void addstudent() {
    }
}
