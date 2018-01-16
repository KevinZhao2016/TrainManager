package com.dao;

import com.model.UsersEntity;

import java.util.List;
public interface UserDao {
    List ListUser();

    String Login(String TelNum, String Password);

    int Register(UsersEntity user);

    Boolean UpdateUser(UsersEntity usersEntity);

    UsersEntity findUserById(int id);

    Boolean DeleteUser(int id);
}



