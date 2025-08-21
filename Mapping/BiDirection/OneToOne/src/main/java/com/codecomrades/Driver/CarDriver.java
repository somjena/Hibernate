package com.codecomrades.Driver;

import com.codecomrades.Entity.Car;
import com.codecomrades.Entity.Engine;
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
       sc= new Scanner(System.in);
    }

    public static void main(String[] args) {

        boolean option = true;
        while(option){
            System.out.println("1.Save\n2.Delete\n3.Update\n4.SearchById\n5.findAll");
            int choice = sc.nextInt();
            switch (choice){
                case 1:save();
                break;
                case 2:delete();
                break;
                case 3:Update();
                break;

            }
        }



    }

    private static void Update() {
        System.out.println("Update Method Invoked");
    }

    private static void delete() {
        System.out.println("Delete Method Invoked");
    }

    private static void save() {
        Car c = new Car();
        Engine e = new Engine();
        System.out.println("Enter the Car name");
        sc.nextLine();
        c.setC_name(sc.nextLine());
        System.out.println("Enter the Car Price");
        c.setC_price(sc.nextInt());
        System.out.println("Enter the Engine type");
        sc.nextLine();
        e.setE_type(sc.nextLine());
        System.out.println("Enter the Engine CC");
        e.setE_cc(sc.nextInt());
        c.setEngine(e);
        e.setCar(c);
        et.begin();
        em.persist(c);//Here we Save Only Car But it Will Save Both the Entity Because We Use Cascade Type
        et.commit();

        System.out.println("Data Saved SuccessFully");
    }
}
