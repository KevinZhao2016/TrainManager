package com.dao.impl;

import com.dao.HibernateUtil;
import com.dao.impl.StationDao;
import com.entity.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class StationDaoImpl implements StationDao {
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
