package com.service;

import com.entity.UsersEntity;

import java.util.List;

/**
 * Created by lipen on 2018/1/8.
 */
public interface UserManageServer {
    List ListUser();

    Boolean UpdateUser(UsersEntity usersEntity);

    UsersEntity findUserById(int id);

    Boolean DeleteUser(int id);
}
