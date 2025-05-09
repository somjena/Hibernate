package com.codecomrades.Driver;

import com.codecomrades.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class User {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction et;
    private static Scanner sc;


    static {
        emf = Persistence.createEntityManagerFactory("ManyToOne");
        em = emf.createEntityManager();
        et=em.getTransaction();
        sc= new Scanner(System.in);
    }
    public static void main(String[] args) {


        boolean flag = true;
        while(true){
            System.out.println("Enter the Option u want to Perform");
            System.out.println("1.addProduct\n2.addReviewForProduct");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    addProduct();
            }
        }
    }


    public static void addProduct(){
        Product p1 = new Product();
        System.out.println("Enter the product Name");
        sc.nextLine();
        p1.setP_name(sc.nextLine());
        System.out.println("Enter the Product Price");
        p1.setP_price(sc.nextInt());
        et.begin();
        em.persist(p1);
        et.commit();
        System.out.println("Data Saved");
    }
    
}
