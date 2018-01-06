package com.service.impl;

import com.dao.impl.UserDaoImpl;
import com.service.LoginServer;


public class LoginServerImpl implements LoginServer {
    @Override
    public String Login(String TelNum, String Password) {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.Login(TelNum, Password);
        return userDaoImpl.Login(TelNum, Password);
    }
}
