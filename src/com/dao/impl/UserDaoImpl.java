package com.dao.impl;

import com.entity.UsersEntity;

import java.util.List;
public interface UserDaoImpl {
    public List ListUser();

    public int Login(String TelNum,String Password);

    public int Register(UsersEntity user);
}
