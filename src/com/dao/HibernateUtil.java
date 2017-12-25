package com.dao;

import com.entity.UsersEntity;
import org.hibernate.*;
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

    public int Login(String TelNum,String Password){
        Session session = new HibernateUtil().getSession();
        try{
            String hql = "from UsersEntity where telNum = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0,TelNum);
            List<UsersEntity> userlist = query.list();
            if(userlist.size() != 0){
                UsersEntity user = userlist.get(0);
                String pwd = user.getPasswd();
                if (pwd.equals(Password)){
                    return user.getId();
                }else {
                    return 0;
                }
            } else
                return 0;
        }catch (HibernateException e) {
            e.printStackTrace();
            return 0;
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
        }finally {
            session.close();
        }
    }
}
