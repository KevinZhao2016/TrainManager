package com.dao.impl;

import com.dao.HibernateUtil;
import com.dao.UserDao;
import com.entity.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public List ListUser() {
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

    public String Login(String TelNum,String Password){
        Session session = new HibernateUtil().getSession();
        try{
            String hql = "from UsersEntity where telNum = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0,TelNum);
            UsersEntity user = (UsersEntity)query.uniqueResult();
            if(user != null){
                String pwd = user.getPasswd();
                if (pwd.equals(Password)){
                    return user.getName();
                }else {
                    return null;
                }
            } else
                return null;
        }catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public int Register(UsersEntity user){
        Session session = new HibernateUtil().getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.save(user);
            tran.commit();
            return 1;
        }catch (HibernateException e){
            e.printStackTrace();
            tran.rollback();
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        finally {
            session.close();
        }
    }
}
