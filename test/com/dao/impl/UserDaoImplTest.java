package com.dao.impl;

import com.entity.UsersEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void listUser() {
    }

    @Test
    public void login() {
    }

    @Test
    public void register() {
    }

    @Test
    public void updateUser() {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(28);
        usersEntity.setTelNum("15968190");
        usersEntity.setPasswd("1234");
        usersEntity.setName("zhao");
        userDao.UpdateUser(usersEntity);
    }

    @Test
    public void findUserById() {
    }

    @Test
    public void deleteUser() {
        userDao.DeleteUser(28);
    }
}