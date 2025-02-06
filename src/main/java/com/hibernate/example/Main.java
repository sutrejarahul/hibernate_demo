package com.hibernate.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();

        student.setRollNo(4);
        student.setName("Jadeja");
        student.setAge(35);

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(com.hibernate.example.Student.class).configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // session.persist(student); to save the record
       //  session.merge(student); // update the record if exist otherwise create new entry of it
        session.remove(student); // to delete the entry
        Student s = session.get(Student.class, 4);
        transaction.commit();
        sessionFactory.close();
        System.out.println(s);
    }
}