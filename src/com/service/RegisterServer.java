package com.service;

import com.dao.HibernateUtil;
import com.dao.UserDao;
import com.entity.UsersEntity;

public class RegisterServer {

    public int Register(UsersEntity user){
        UserDao userDao = new UserDao();
        return userDao.Register(user);
    }
}
