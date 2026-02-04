package schema;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    static void main() {

        Employee employee1 = new Employee();

        Laptop l1 = new Laptop();
        l1.setLaptop_id(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRAM(16);

        Laptop l2 = new Laptop();
        l2.setLaptop_id(2);
        l2.setBrand("DELL");
        l2.setModel("XPS");
        l2.setRAM(32);

        l1.setEmployee(employee1);
        l2.setEmployee(employee1);

        employee1.setsId(101);
        employee1.setName("Shiva");
        employee1.setCourse("IT");
        employee1.setTech("Java");
        employee1.setLaptops(Arrays.asList(l1, l2));

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        session.persist(l1);
        session.persist(l2);
        session.persist(employee1);

        Employee m1 = session.find(Employee.class, 101);

        System.out.println(m1);

        transaction.commit();

        session.close();
        sessionFactory.close();


    }
}
