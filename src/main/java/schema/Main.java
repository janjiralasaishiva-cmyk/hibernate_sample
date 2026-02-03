package schema;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    static void main() {

        SchemaModification modification = new SchemaModification();

        modification.setsId(101);
        modification.setName("Shiva");
        modification.setCourse("IT");
        modification.setTech("Java");

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(SchemaModification.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(modification);

        transaction.commit();

        session.close();
        sessionFactory.close();


    }
}
