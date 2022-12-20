package com.goit.feature.database.hibernate;

import com.goit.feature.client.Client;
import com.goit.feature.planet.Planet;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    @Getter
    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }

    public static void main(String[] args) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Planet planet = session.get(Planet.class, "VEN");
        Client client = session.get(Client.class, 3L);
        System.out.println("planet = " + planet);
        System.out.println("client = " + client);
        session.close();
    }
}
