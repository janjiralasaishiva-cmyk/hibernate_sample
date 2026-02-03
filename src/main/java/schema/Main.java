package schema;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    static void main() {

        SchemaModification modification = new SchemaModification();

        Laptop l1 = new Laptop();

        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRAM(16);

        modification.setsId(101);
        modification.setName("Shiva");
        modification.setCourse("IT");
        modification.setTech("Java");
        modification.setLaptop(l1);

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(SchemaModification.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(modification);

        transaction.commit();

        SchemaModification m1 = session.find(SchemaModification.class, 101);

        System.out.println(m1.getLaptop());


        session.close();
        sessionFactory.close();


    }
}
