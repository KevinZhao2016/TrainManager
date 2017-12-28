package com.dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    private UserDao user = new UserDao();
    @Test
    public void listUser() {
    }

    @Test
    public void login() {
        System.out.println(user.Login("13396681253","123456"));
    }
}