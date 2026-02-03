package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class CRUDOperation {
    static void main() {

        Student student1 = new Student();

        student1.setRollNo(24);
        student1.setsName("Saishiva");
        student1.setAge(21);
        student1.setlName("Janjirala");

        // Fetching data from PostgreSQL;
//        Student student2 = null;

//        Configuration config = new Configuration();
//        config.addAnnotatedClass(org.example.Student.class);
//        config.configure();

//      Session is not thread safe and must never be shared between threads.
        // session holds one JDBC connection at a time
        // A JDBC Connection cannot be used by multiple threads.
//        SessionFactory sessionFactory = new Configuration()
//                                            .addAnnotatedClass(org.example.Student.class)
//                                            .configure()
//                                            .buildSessionFactory();
//
//        // Session creation using sessionFactory.openSession();
//        Session session = sessionFactory.openSession();
////        Session session1 = sessionFactory.openSession();
//
//        // Only for insertion, updating, deletion from the database
//        Transaction transaction = session.beginTransaction();
//        // TO store, update, or delete from database
//        // Here I have created the data and stored it inside the PostgreSql.
//        // session.persist(student1);
//
//        // To retrieve data using primary key
////        student2 = session.find(Student.class, 7);
////        Student s = session.load(Student.class, 17);
//
//        // Retrieves the entire data like "Select * from Student;"
////        List<Student> students = session.createQuery("from Student", Student.class).getResultList();
////        System.out.println(students);
//
//
//
//        // For updating the database
////        session.merge(student1);
//
//        // For deleting the data
//        // One way is that we can get the object and remove it
//        // Using Student s1 =  session.find(Student.class, 25);
//        Student s1 = session.find(Student.class, 25);
//        // Or we can just create the same data as from the database and remove it using session.remove(student1);
//        session.remove(s1);
//        // For Creating, updating or deleting into database
//        transaction.commit();
//
//        session.close();
//        sessionFactory.close();
//        System.out.println(student1);
//        System.out.println(student2 == null ? "Student not present" : student2.getlName());
    }
}
