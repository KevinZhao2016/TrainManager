package com.action;

import com.entity.UsersEntity;
import com.service.impl.RegisterServerImpl;

public class RegisterAction {
    private String userName;
    private String password;
    private String telNum;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelNum(){ return telNum; }

    public void setTelNum(String telNum){ this.telNum = telNum; }

    public String execute() throws Exception {
        UsersEntity user = new UsersEntity();
        user.setTelNum(getTelNum());
        user.setName(getUserName());
        user.setPasswd(getPassword());
        RegisterServerImpl registerServerImpl = new RegisterServerImpl();
        if (1 == registerServerImpl.Register(user)) {
            return "success";
        } else
            return "fail";
    }
}
