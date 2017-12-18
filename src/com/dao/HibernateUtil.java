package com.dao;

import com.entity.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateUtil {
    public Session getSession() {
        Configuration cof = new Configuration();
        cof.configure();
        SessionFactory sf = cof.buildSessionFactory();
        Session session = sf.openSession();
        return session;
    }

    public List list() {
        Session session = new HibernateUtil().getSession();
        try {
            List<UsersEntity> list = session.createQuery("FROM UsersEntity user").list();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
