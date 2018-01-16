package com.action;

import com.model.UsersEntity;
import com.opensymphony.xwork2.ActionContext;
import com.service.impl.UserManagerServerImpl;

import java.util.List;
import java.util.Map;

/**
 * Created by lipen on 2018/1/8.
 */
public class UserMngAction {
    private int id;
    private String name;
    private String passwd;
    private String telNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    private UserManagerServerImpl userManagerServer = new UserManagerServerImpl();

    private UsersEntity setUsersEntity() {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(this.getId());
        usersEntity.setName(this.getName());
        usersEntity.setPasswd(this.getPasswd());
        usersEntity.setTelNum(this.getTelNum());
        return usersEntity;
    }

    public String List() throws Exception {
        List<UsersEntity> list = userManagerServer.ListUser();
        if (list != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("UsersList", list);
            return "success";
        } else
            return "fail";
    }

    public String Update() throws Exception {
        UsersEntity usersEntity = this.setUsersEntity();
        if (userManagerServer.UpdateUser(usersEntity)) {
            this.List();
            return "success";
        } else {
            return "fail";
        }
    }


    public String Delete() throws Exception {
        UsersEntity usersEntity = this.setUsersEntity();
        if (userManagerServer.DeleteUser(this.getId())) {
            this.List();
            return "success";
        } else {
            return "fail";
        }
    }

    public String findRouteById() throws Exception {
        int id = this.getId();
        UsersEntity usersEntity = userManagerServer.findUserById(id);
        if (usersEntity != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("usersEntity", usersEntity);
            return "success";
        } else
            return "fail";
    }
}
