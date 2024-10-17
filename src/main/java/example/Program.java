package example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Person person1 = new Person("Dima", 25);
        Person person2 = new Person("Vika", 18);

        session.save(person1);
        session.save(person2);

        session.getTransaction().commit();
        session.close();
    }
}
