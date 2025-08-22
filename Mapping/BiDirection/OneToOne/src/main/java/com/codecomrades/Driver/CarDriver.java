package com.codecomrades.Driver;

import com.codecomrades.Entity.Car;
import com.codecomrades.Entity.Engine;
import jakarta.persistence.*;

import java.util.List;
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
                case 4:SearchbyId();
                break;
                case 5:Findall();

            }
        }



    }

    private static void SearchbyId() {
        System.out.println("Enter the Car id You Want to Find");
        Car c =em.find(Car.class,sc.nextInt());
        if(c==null){
            System.out.println("No Data Records Are There for this Id");
        }else{

            Engine e =c.getEngine();
            System.out.println("Car name :- "+c.getC_name() +"| Car id: -"+c.getC_id() +"| Car Price :- "+c.getC_price() +"| Engine Id :- "+e.getE_id()+"| Engine type :- "+e.getE_type() + "| Engine CC :- "+e.getE_cc());
        }
        }

    private static void Findall() {
        String s = "from Car";
        Query q=em.createQuery(s);
        List<Car> l =q.getResultList();
        for (Car c : l){
            Engine e = c.getEngine();
            System.out.println("Car name :- "+c.getC_name() +"| Car id: -"+c.getC_id() +"| Car Price :- "+c.getC_price() +"| Engine Id :- "+e.getE_id()+"| Engine type :- "+e.getE_type() + "| Engine CC :- "+e.getE_cc());
        }

    }

    private static void Update() {

        System.out.println("Enter the Car id U want to Update");
        Car C=em.find(Car.class,sc.nextInt());
        System.out.println("Enter the Choice U Want to Update");
        System.out.println("1.Update_Name\n2.Update_Price");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter the Name You Want to Update");
                sc.nextLine();
                C.setC_name(sc.nextLine());
                et.begin();
                em.persist(C);
                et.commit();
                System.out.println("Successfully Updated the Name Of The Car");
                break;
            case 2:
                System.out.println("Enter the Price You Want to Update");
                C.setC_price(sc.nextInt());
                et.begin();
                em.persist(C);
                et.commit();
                System.out.println("Successfully Car Price Update");
        }



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
