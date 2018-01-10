package com.service.impl;

import com.dao.impl.UserDaoImpl;
import com.entity.UsersEntity;
import com.service.UserManageServer;

import java.util.List;

public class UserManagerServerImpl implements UserManageServer {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public List ListUser() {
        List<UsersEntity> list = userDao.ListUser();
        return list;
    }

    @Override
    public Boolean UpdateUser(UsersEntity usersEntity) {
        return userDao.UpdateUser(usersEntity);
    }

    @Override
    public UsersEntity findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public Boolean DeleteUser(int id) {
        return userDao.DeleteUser(id);
    }
}
