package com.dao.impl;

import com.dao.HibernateUtil;
import com.dao.StationDao;
import com.model.StationEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StationDaoImpl implements StationDao {
    HibernateUtil hibernateUtil = new HibernateUtil();
    public List ListStation() {
        Session session = hibernateUtil.getSession();
        try {
            List<StationEntity> list = session.createQuery("FROM StationEntity station").list();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Boolean UpdateStation(StationEntity stationEntity) {
        Session session = hibernateUtil.getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.update(stationEntity);
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
    public Boolean AddStation(StationEntity stationEntity) {
        Session session = hibernateUtil.getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.save(stationEntity);
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
    public Boolean DeleteStation(StationEntity stationEntity) {
        Session session = hibernateUtil.getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.delete(stationEntity);
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
    public StationEntity findStationById(int id) {
        Session session = hibernateUtil.getSession();
        String hql = "from StationEntity where id = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        StationEntity stationEntity = (StationEntity) query.uniqueResult();
        if (stationEntity != null) {
            return stationEntity;
        } else {
            return new StationEntity();
        }
    }

}
