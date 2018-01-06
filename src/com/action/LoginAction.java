package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.service.impl.LoginServerImpl;

import java.util.Map;

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
        LoginServerImpl loginServerImpl = new LoginServerImpl();
        String userName = loginServerImpl.Login(telNum,password);
        if (userName != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("userName",userName);
            return "success";
        } else
            return "fail";
    }
}
