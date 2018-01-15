package com.action;

import com.entity.StationEntity;
import com.opensymphony.xwork2.ActionContext;
import com.service.impl.StationManagerServerImpl;

import java.util.List;
import java.util.Map;

/**
 * Created by lipen on 2018/1/8.
 */
public class StationMngAction {
    private int id;
    private String name;
    private String pinyin;
    private StationManagerServerImpl stationManagerServer = new StationManagerServerImpl();

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

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    private StationEntity setStationEntity() {
        StationEntity stationEntity = new StationEntity();
        stationEntity.setId(this.getId());
        stationEntity.setName(this.getName());
        stationEntity.setPinyin(this.getPinyin());
        return stationEntity;
    }

    public String List() throws Exception {
        List<StationEntity> list = stationManagerServer.ListStation();
        if (list != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("StationList", list);
            return "success";
        } else
            return "fail";
    }

    public String Update() throws Exception {
        StationEntity stationEntity = this.setStationEntity();
        if (stationManagerServer.UpdateStation(stationEntity)) {
            this.List();
            return "success";
        } else {
            return "fail";
        }
    }

    public String Add() throws Exception {
        StationEntity stationEntity = this.setStationEntity();
        if (stationManagerServer.AddStation(stationEntity)) {
            this.List();
            return "success";
        } else {
            return "fail";
        }
    }

    public String Delete() throws Exception {
        if (stationManagerServer.DeleteStation(this.getId())) {
            this.List();
            return "success";
        } else {
            return "fail";
        }
    }

    public String findRouteById() throws Exception {
        int id = this.getId();
        StationEntity stationEntity = stationManagerServer.findStationById(id);
        if (stationEntity != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("stationEntity", stationEntity);
            return "success";
        } else
            return "fail";
    }
}
