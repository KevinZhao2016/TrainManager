package com.dao;

import com.dao.impl.RouteDaoImpl;
import com.entity.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class RouteDao implements RouteDaoImpl {
    public List ListRoute() {
        Session session = new HibernateUtil().getSession();
        try {
            List<UsersEntity> list = session.createQuery("FROM RouteEntity route").list();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
