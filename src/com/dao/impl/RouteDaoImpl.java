package com.dao.impl;

import com.dao.HibernateUtil;
import com.dao.RouteDao;
import com.entity.RouteEntity;
import com.entity.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RouteDaoImpl implements RouteDao {
    HibernateUtil hibernateUtil = new HibernateUtil();
    public List ListRoute() {
        Session session = hibernateUtil.getSession();
        try {
            List<RouteEntity> list = session.createQuery("FROM RouteEntity route").list();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Boolean UpdateRoute(RouteEntity routeEntity) {
        Session session = hibernateUtil.getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.update(routeEntity);
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
    public Boolean AddRoute(RouteEntity routeEntity) {
        Session session = hibernateUtil.getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.save(routeEntity);
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
    public Boolean DeleteRoute(RouteEntity routeEntity) {
        Session session = hibernateUtil.getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.delete(routeEntity);
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
    public RouteEntity findRouteById(int id) {
        Session session = hibernateUtil.getSession();
        String hql = "from RouteEntity where id = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        RouteEntity routeEntity = (RouteEntity) query.uniqueResult();
        if (routeEntity != null) {
            return routeEntity;
        } else {
            return new RouteEntity();
        }
    }
}