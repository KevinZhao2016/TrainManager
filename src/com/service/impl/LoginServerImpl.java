package com.service.impl;

import com.dao.impl.UserDaoImpl;
import com.service.LoginServer;


public class LoginServerImpl implements LoginServer {
    @Override
    public int Login(String TelNum, String Password) {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        return userDaoImpl.Login(TelNum, Password);
    }
}
