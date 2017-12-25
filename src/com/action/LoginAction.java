package com.action;

import com.dao.HibernateUtil;


public class LoginAction {
    private String password;
    private String telNum;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelNum(){ return telNum; }

    public void setTelNum(String telNum){ this.telNum = telNum; }


    public String execute() throws Exception {
        HibernateUtil util = new HibernateUtil();
        if (util.Login(telNum,password) != 0) {
            return "success";
        } else
            return "fail";
    }
}
