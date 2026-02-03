package schema;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    static void main() {

        Employee student1 = new Employee();

        Laptop l1 = new Laptop();
        l1.setLaptop_id(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRAM(16);

        student1.setsId(101);
        student1.setName("Shiva");
        student1.setCourse("IT");
        student1.setTech("Java");
        student1.setLaptop(l1);

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        session.persist(l1);
        session.persist(student1);

        Employee m1 = session.find(Employee.class, 101);

        System.out.println(m1.getLaptop().getBrand());

        transaction.commit();

        session.close();
        sessionFactory.close();


    }
}
