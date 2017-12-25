package com.dao;

import com.entity.UsersEntity;
import org.junit.Test;

import java.util.List;

public class HibernateUtilTest {
    private HibernateUtil util = new HibernateUtil();

    @Test
    public void ListUser() {
        List<UsersEntity> list = util.ListUser();
        for (UsersEntity stu : list) {
            System.out.print(stu.getId() + " ");
            System.out.println(stu.getName());
        }
    }

    @Test
    public void Login() {
        System.out.println(util.Login("13396681253","123456"));
    }
}