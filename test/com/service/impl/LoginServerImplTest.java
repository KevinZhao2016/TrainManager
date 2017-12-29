package com.service.impl;

import com.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginServerImplTest {
    private UserDaoImpl user = new UserDaoImpl();
    @Test
    public void login() {
        System.out.println(user.Login("13396681253","123456"));
    }
}