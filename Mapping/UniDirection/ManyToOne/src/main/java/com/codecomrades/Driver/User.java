package com.codecomrades.Driver;

import com.codecomrades.entity.Product;
import com.codecomrades.entity.Reviews;
import jakarta.persistence.*;

import java.util.List;
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
            System.out.println("1.AddProduct\n2.AddReviewForProduct\n3.DeleteReview");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    addProduct();
                    break;
                case 2:
                    addreview();
                    break;
                case 3:
                    deletereview();
                    break;
                case 4:
                    getdetailsbyid();
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
    public static void addreview(){
        String query = "from Product";
       Query qr =  em.createQuery(query);
       List<Product> productList = qr.getResultList();
        System.out.println("List of All the Product");
       for (Product product :productList) {
           System.out.println(product.getP_id() + " " + product.getP_name() + " " + product.getP_price());
       }
           System.out.println("Enter the Product id U want to Add Review");
           Product prd =em.find(Product.class,sc.nextInt());
           Reviews reviews = new Reviews();
           System.out.println("Enter the Review Title");
           sc.nextLine();
           reviews.setTitle(sc.nextLine());
           reviews.setProduct(prd);
           et.begin();
           em.persist(prd);
           em.persist(reviews);
           et.commit();
           System.out.println("Reviews Added to Your Choice Product");
        System.out.println("___________________________________________");


    }

    public static void deletereview(){
        System.out.println("Enter the review id U want to Delete");
        Reviews reviews = em.find(Reviews.class, sc.nextInt());
        if(reviews!=null){
            et.begin();
            em.remove(reviews);
            et.commit();
            System.out.println("Deleted Your Review");
        }else{
            System.out.println("Review id does not exist");
        }
    }
    private static void getdetailsbyid() {
        System.out.println("Enter the Product id U want to Search");
        Product product = em.find(Product.class, sc.nextInt());
        if (product!=null){
            System.out.println("Here is the Details ||->");
            System.out.println(product.getP_name()+ " "+product.getP_id());
        }
    }
}
