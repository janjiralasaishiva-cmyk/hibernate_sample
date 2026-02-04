package schema;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    static void main() {

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();

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

        Laptop l3 = new Laptop();
        l3.setLaptop_id(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook air");
        l3.setRAM(16);


        employee1.setsId(101);
        employee1.setName("Shiva");
        employee1.setCourse("IT");
        employee1.setTech("Java");

        employee2.setsId(102);
        employee2.setName("Teja");
        employee2.setCourse("EEE");
        employee2.setTech("Java");

        employee3.setsId(103);
        employee3.setName("Krishn");
        employee3.setCourse("CSE");
        employee3.setTech("Python");

        employee1.setLaptops(Arrays.asList(l1, l2));
        employee2.setLaptops(Arrays.asList(l2, l3));
        employee3.setLaptops(Arrays.asList(l3));

        l1.setEmployee(Arrays.asList(employee1));
        l2.setEmployee(Arrays.asList(employee1, employee2));
        l3.setEmployee(Arrays.asList(employee3, employee2));

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(employee1);
        session.persist(employee2);
        session.persist(employee3);

        Employee m1 = session.find(Employee.class, 103);

        System.out.println(m1);

        transaction.commit();

        session.close();
        sessionFactory.close();


    }
}
