package com.dao.impl;

import com.dao.HibernateUtil;
import com.dao.RouteDao;
import com.entity.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class RouteDaoImpl implements RouteDao {
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