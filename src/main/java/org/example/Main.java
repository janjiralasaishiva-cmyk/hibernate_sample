package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    static void main() {

        Student student1 = new Student();

        student1.setRollNo(25);
        student1.setsName("Saishiva");
        student1.setAge(21);
        student1.setlName("Janjirala");

        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.Student.class);
        config.configure();

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
//        Session session1 = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(student1);
//        session1.persist(student1);
        transaction.commit();
        System.out.println(student1);
    }
}
