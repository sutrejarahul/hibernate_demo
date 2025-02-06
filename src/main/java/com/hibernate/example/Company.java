package com.hibernate.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Company {

    public static void main(String[] args) {

        Address a1 = new Address();
        a1.setState("Gujarat");
        a1.setCity("Junagadh");
        a1.setZipCode("362002");

        Address a2 = new Address();
        a2.setState("Gujarat");
        a2.setCity("Ahemdabad");
        a2.setZipCode("38060 ");

        Address a3 = new Address();
        a3.setState("Gujarat");
        a3.setCity("Rajkot");
        a3.setZipCode("38070 ");

        Employee e1 = new Employee();
        e1.setName("Clark");
        e1.setAddresses(List.of(a1,a2));

        Employee e2 = new Employee();
        e2.setName("Bruce");
        e2.setAddresses(List.of(a3));

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        session.persist(e1);
        session.persist(e2);

        transaction.commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        Employee employee = session2.get(Employee.class, 1);
        System.out.println(employee);
        session2.close();

        sessionFactory.close();



    }
}
