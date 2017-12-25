package com.service;

import com.dao.HibernateUtil;
import com.entity.UsersEntity;

public class RegisterServer {

    public int Register(UsersEntity user){
        HibernateUtil util = new HibernateUtil();
        return util.Register(user);
    }
}
