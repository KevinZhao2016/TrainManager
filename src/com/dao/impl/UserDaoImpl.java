package com.dao.impl;

import com.dao.HibernateUtil;
import com.dao.UserDao;
import com.model.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
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

    @Override
    public String Login(String TelNum, String Password){
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

    @Override
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
        } finally {
            session.close();
        }
    }

    @Override
    public Boolean UpdateUser(UsersEntity usersEntity) {
        Session session = new HibernateUtil().getSession();
        Transaction tran = session.beginTransaction();
//        String hql = "update UsersEntity as user set user.telNum = ?,user.passwd = ?,user.name = ? where user.id = ?";
//        Query query = session.createQuery(hql);
//        query.setParameter(0,usersEntity.getTelNum());
//        query.setParameter(1,usersEntity.getPasswd());
//        query.setParameter(2,usersEntity.getName());
//        query.setParameter(3,usersEntity.getId());
        try {
            session.update(usersEntity);
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
    public UsersEntity findUserById(int id) {
        Session session = new HibernateUtil().getSession();
        String hql = "from UsersEntity where id = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        UsersEntity user = (UsersEntity) query.uniqueResult();
        if (user != null) {
            return user;
        } else {
            return new UsersEntity();
        }
    }

    @Override
    public Boolean DeleteUser(int id) {
        Session session = new HibernateUtil().getSession();
        UsersEntity user = this.findUserById(id);
        Transaction tran = session.beginTransaction();
        try {
            session.delete(user);
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
}
