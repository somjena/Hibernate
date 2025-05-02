package com.codecomrades.controller;

import com.codecomrades.entity.Student;
import jakarta.persistence.*;

import java.util.List;
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
             System.out.println("1.save\n2.delete\n3.update\n4.getAll\n5.getByid\n6.exit");
             int choice=sc.nextInt();
             switch (choice){
                 case 1:save();
                 break;
                 case 2:delete();
                     break;
                 case 3:Update();
                     break;
                 case 4:getall();
                     break;
                 case 5:getbyid();
                         break;
                 case 6:return;

                 default:
                     System.out.println("Enter a Valid Choice");
             }
         }





    }



    private static void getbyid() {
        System.out.println("Enter the Id U want to Get");
       Student std= em.find(Student.class, sc.nextInt());
       if(std!=null){
           System.out.println(std.getSid() +" "+std.getSname()+" "+std.getSage() + " "+ std.getMark());
       }
        System.out.println("User not Found with this Id");

    }

    private static void getall() {
        String sql = "from Student";
      Query qr =  em.createQuery(sql);
      List<Student> studentList=qr.getResultList();
      for(Student s :studentList){
          System.out.println(s.getSid()+" "+s.getSname()+" "+s.getMark() +" "+s.getMark());
      }

    }

    private static void Update() {
        System.out.println("Enter the Student id U want to Update");
        Student st =em.find(Student.class,sc.nextInt());
        if(st!=null){
            System.out.println("Enter the Name U want to Update");
            sc.nextLine();
            st.setSname(sc.nextLine());
            System.out.println("Enter the Age u want to Update");
            st.setSage(sc.nextInt());
            System.out.println("Enter the Mark U want to Update");
            st.setMark(sc.nextInt());
            et.begin();
            em.merge(st);
            et.commit();

            System.out.println("Successfully Updated the Data ");
        }
    }

    private static void delete() {
        System.out.println("Enter the id U want to Delete");
       Student st= em.find(Student.class,sc.nextInt());
       if(st!=null){
           et.begin();
           em.remove(st);
           et.commit();
           System.out.println("Successfully Deleted the Student");
       }else {
           System.out.println("Data Not Available");
       }

    }

    private static void save() {
        Student s1 = new Student();
        System.out.println("Enter the id");
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
        System.out.println("Data Saved with " + s1.getSid());
    }
}
