package com.dao;

import com.entity.UsersEntity;

import java.util.List;
public interface UserDao {
    public List ListUser();

    public String Login(String TelNum,String Password);

    public int Register(UsersEntity user);
}



