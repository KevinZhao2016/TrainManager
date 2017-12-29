package com.dao.impl;

import com.dao.HibernateUtil;
import com.dao.impl.TripsDao;
import com.entity.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class TripsDaoImpl implements TripsDao {
    public List ListTrips() {
        Session session = new HibernateUtil().getSession();
        try {
            List<UsersEntity> list = session.createQuery("FROM TripsEntity trips").list();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}