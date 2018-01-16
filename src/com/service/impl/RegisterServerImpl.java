package com.service.impl;


import com.dao.impl.UserDaoImpl;
import com.model.UsersEntity;
import com.service.RegisterServer;


public class RegisterServerImpl implements RegisterServer {
    @Override
    public int Register(UsersEntity user){
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        return userDaoImpl.Register(user);
    }
}
