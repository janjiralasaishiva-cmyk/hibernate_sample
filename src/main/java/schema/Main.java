package schema;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Main {
    static void main() {

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        // select * from Laptop where RAM = 32; -> SQL
        // from Laptop where RAM = 32 -> HQL

        // To work with a specific column
        // If we are having multiple columns then ?1, ?2, ?3, ...
        String brand = "Asus";

        Query query = session.createQuery("select brand, model from Laptop where brand like ?1");
        query.setParameter(1, brand);

        List<Object[]> laptops = query.getResultList();

//        Laptop laptop = session.find(Laptop.class, 111);

        for(Object[] data : laptops){
            System.out.println(data[0]+" " + data[1]);
        }
//        System.out.println(laptops);

        transaction.commit();

        session.close();
        sessionFactory.close();

    }
}
