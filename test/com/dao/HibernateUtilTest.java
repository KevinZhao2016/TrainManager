package com.dao;

import com.entity.UsersEntity;
import org.junit.Test;

import java.util.List;

public class HibernateUtilTest {
    private HibernateUtil util = new HibernateUtil();

    @Test
    public void list() {
        List<UsersEntity> list = util.list();
        for (UsersEntity stu : list) {
            System.out.print(stu.getId() + " ");
            System.out.println(stu.getName());
        }
    }
}