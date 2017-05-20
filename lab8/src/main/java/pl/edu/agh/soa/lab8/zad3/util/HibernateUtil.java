package pl.edu.agh.soa.lab8.zad3.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) sessionFactory = buildSessionAnnotationFactory();
        return sessionFactory;
    }

    private static SessionFactory buildSessionAnnotationFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}