package com.util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static Configuration cof = new Configuration();

    public Session getSession() {
        cof.configure();
        SessionFactory sf = cof.buildSessionFactory();
        Session session = sf.openSession();
        return session;
    }

}