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
        emf = Persistence.createEntityManagerFactory("OneToOneBi");
        em = emf.createEntityManager();
        et = em.getTransaction();
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to The Car Management Application");
        boolean flag = true;
        while (flag){
            System.out.println("1.Add Car and Engine\n2.Delete a Car\n3.Update the Car Engine\n4.View All Car\n5.GetCarDetailsByid");
            int choice = sc.nextInt();
            switch (choice){
                case 1:save();
                break;
                case 2:delete();
                break;
                case 3:update();
                break;
                case 4:viewcar();
                break;
                case 5:getbycid();
                break;
            }
        }

    }

    private static void getbycid() {
        System.out.println("Enter the Car id U want to Search");
        Car car =em.find(Car.class,sc.nextInt());
        System.out.println(car.getC_name());

    }

    private static void viewcar() {
        String sql = "from Car";
        Query qr = em.createQuery(sql);
        List<Car> carlist=qr.getResultList();
        for(Car cr :carlist){
            Engine e =cr.getEngine();
            System.out.println(cr.getC_name() +" "+ cr.getC_id()+" "+cr.getC_price()+" "+e.getE_id() +" "+e.getE_type() +" "+e.getE_cc());
        }

    }

    private static void update() {
    }

    private static void delete() {
        System.out.println("Enter the Car Id U want to Delete");
       Car dlc = em.find(Car.class,sc.nextInt());
       et.begin();
       em.remove(dlc);
       et.commit();
       System.out.println("Successfully Deleted the Car");
    }

    private static void save() {
        Car car = new Car();
        Engine e = new Engine();
        System.out.println("Enter the Car Name");
        sc.nextLine();
        car.setC_name(sc.nextLine());
        System.out.println("Enter the Car Price");
        car.setC_price(sc.nextInt());
        System.out.println("Enter the Engine CC");
        e.setE_cc(sc.nextInt());
        System.out.println("Enter the Engine Type");
        sc.nextLine();
        e.setE_type(sc.nextLine());
        car.setEngine(e);
        e.setCar(car);

        et.begin();
        em.persist(car);
        et.commit();
        System.out.println("Car Saved into The Database");

    }


}
