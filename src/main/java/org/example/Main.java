package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {
    static void main() {

        Student student1 = new Student();

        student1.setRollNo(12);
        student1.setsName("Sai");
        student1.setAge(20);
        student1.setlName("Janjirala");

        // Fetching data from PostgreSQL;
        Student student2 = null;

//        Configuration config = new Configuration();
//        config.addAnnotatedClass(org.example.Student.class);
//        config.configure();

//      Session is not thread safe and must never be shared between threads.
        // session holds one JDBC connection at a time
        // A JDBC Connection cannot be used by multiple threads.
        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(org.example.Student.class).configure().buildSessionFactory();

        // Session creation using sessionFactory.openSession();
        Session session = sessionFactory.openSession();
//        Session session1 = sessionFactory.openSession();

        // Only for insertion, updating, deletion from the database
//        Transaction transaction = session.beginTransaction();
        // TO store, update, or delete from database
//        session.persist(student1);

        // To retrieve data using primary key
//        student2 = session.find(Student.class, 7);
        List<Student> students = session.createQuery("from Student", Student.class).getResultList();

        System.out.println(students);


//        transaction.commit();
//        session.close();
        sessionFactory.close();
        System.out.println(student2);
    }
}
