package com.dao.impl;

import com.dao.HibernateUtil;
import com.dao.TripsDao;
import com.entity.TripsEntity;
import com.entity.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TripsDaoImpl implements TripsDao {
    HibernateUtil hibernateUtil = new HibernateUtil();
    public List ListTrips() {
        Session session = hibernateUtil.getSession();
        try {
            List<TripsEntity> list = session.createQuery("FROM TripsEntity trips").list();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Boolean AddTrips(TripsEntity tripsEntity) {
        Session session = hibernateUtil.getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.save(tripsEntity);
            tran.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public Boolean UpdateTrips(TripsEntity tripsEntity) {
        Session session = hibernateUtil.getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.update(tripsEntity);
            tran.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public Boolean DeleteTrips(TripsEntity tripsEntity) {
        Session session = hibernateUtil.getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.delete(tripsEntity);
            tran.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public TripsEntity findTripsById(int tid) {
        Session session = hibernateUtil.getSession();
        String hql = "from TripsEntity where tid = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, tid);
        TripsEntity tripsEntity = (TripsEntity) query.uniqueResult();
        if (tripsEntity != null) {
            return tripsEntity;
        } else {
            return new TripsEntity();
        }
    }
}
