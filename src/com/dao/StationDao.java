package com.dao;

import com.dao.impl.StationDaoImpl;
import com.entity.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class StationDao implements StationDaoImpl {
    public List ListStation() {
        Session session = new HibernateUtil().getSession();
        try {
            List<UsersEntity> list = session.createQuery("FROM StationEntity station").list();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
