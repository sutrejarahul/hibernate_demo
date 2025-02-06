package com.hibernate.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Rahul {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setBrand("Asus");
        l1.setModel("ROG");

        Laptop l2 = new Laptop();
        l2.setBrand("Dell");
        l2.setModel("XPS");

        Laptop l3 = new Laptop();
        l3.setBrand("Apple");
        l3.setModel("Mack Book air");

        Aline a1 = new Aline();
        a1.setName("Rahul");
        a1.setTech("Java");

        Aline a2 = new Aline();
        a2.setName("Ravi");
        a2.setTech("Laravel");

        Aline a3 = new Aline();
        a3.setName("Kishan");
        a3.setTech("AI");

        a1.setLaptops(List.of(l1,l2));
        a2.setLaptops(List.of(l2,l3));
        a3.setLaptops(List.of(l1));

        l1.setAlines(List.of(a1,a3));
        l2.setAlines(List.of(a1,a2));
        l3.setAlines(List.of(a3));

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Aline.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        transaction.commit();
        System.out.println(session.get(Aline.class, 1));
        session.close();
        sessionFactory.close();
    }
}
