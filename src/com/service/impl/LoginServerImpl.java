package com.service.impl;

import com.dao.UserDao;
import com.service.LoginServer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class LoginServerImpl implements LoginServer {
    @Override
    public String Login(String TelNum, String Password) {
        Resource resource = new ClassPathResource("beans.xml");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        UserDao userDao = (UserDao) factory.getBean("user_dao");
        return userDao.Login(TelNum, Password);
    }
}
