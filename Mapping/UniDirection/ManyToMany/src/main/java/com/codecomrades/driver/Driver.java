package com.codecomrades.driver;

import com.codecomrades.entity.Students;
import com.codecomrades.entity.Subjects;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
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
                break;
                case 6:UpdateSubject();
                break;
                
            }
        }
    }

    private static void UpdateSubject() {
        System.out.println("Enter the Subject Id U want to Updte");
    }

    private static void UpdateStudent() {
    }
        private static void DeleteSubjectForStudent() {
            System.out.println("Enter the Student Id you want to delete the subject from:");
            int studentId = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            Students sts = em.find(Students.class, studentId);
            if (sts == null) {
                System.out.println("Student not found.");
                return;
            }

            System.out.println("Enter the Subject Id you want to delete:");
            int subjectId = sc.nextInt();
            sc.nextLine(); // optional, depending on further input

            Subjects subject = em.find(Subjects.class, subjectId);
            if (subject == null) {
                System.out.println("Subject not found.");
                return;
            }

            if (!sts.getSubjectsList().contains(subject)) {
                System.out.println("This subject is not associated with the student.");
                return;
            }

            sts.getSubjectsList().remove(subject);

            et.begin();
            em.merge(sts);
            et.commit();

            System.out.println("Successfully deleted the subject from the student.");
        }
    private static void AddSubjectforStudent() {
        System.out.println("Enter the Student ID:");
        int studentId = sc.nextInt();
        sc.nextLine(); // consume newline
        Students student = em.find(Students.class, studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        // Show all available subjects
        String query = "from Subjects";
        List<Subjects> allSubjects = em.createQuery(query, Subjects.class).getResultList();
        System.out.println("Here is the list of available subjects:");
        for (Subjects subject : allSubjects) {
            System.out.println(subject.getSub_id() + ". " + subject.getSub_name() + " (" + subject.getSub_duration() + ")");
        }

        // Ask user to enter subject ID to add
        System.out.println("Enter the Subject ID you want to add for the student:");
        int subjectId = sc.nextInt();
        sc.nextLine(); // consume newline
        Subjects subjectToAdd = em.find(Subjects.class, subjectId);

        if (subjectToAdd == null) {
            System.out.println("Subject not found.");
            return;
        }

        List<Subjects> studentSubjects = student.getSubjectsList();

        if (studentSubjects.contains(subjectToAdd)) {
            System.out.println(student.getS_name() + " is already registered with " + subjectToAdd.getSub_name());
            return;
        }

        // Add the new subject to existing list
        studentSubjects.add(subjectToAdd);
        student.setSubjectsList(studentSubjects);

        et.begin();
        em.merge(student);
        et.commit();

        System.out.println("Successfully added " + subjectToAdd.getSub_name() + " for " + student.getS_name());
    }



        private static void addSubject () {
            Subjects subjects = new Subjects();
            System.out.println("Enter the Subject Name");
            sc.nextLine();
            subjects.setSub_name(sc.nextLine());
            System.out.println("Enter the Subject Duration");
            subjects.setSub_duration(sc.nextInt());
            et.begin();
            em.persist(subjects);
            et.commit();
            System.out.println("Successfully Subject Created");

        }


    private static void addstudent() {
        Students students =new Students();
        System.out.println("Enter the Name of The Student");
        sc.nextLine();
        students.setS_name(sc.nextLine());
        System.out.println("Enter the Student Age");
        students.setAge(sc.nextInt());
        et.begin();
        em.persist(students);
        et.commit();
        System.out.println("Student Data SuccessFully Added to The Db");

    }
}
