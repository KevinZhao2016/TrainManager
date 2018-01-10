package com.action;

import com.entity.RouteEntity;
import com.opensymphony.xwork2.ActionContext;
import com.service.impl.RouteManagerServerImpl;

import java.sql.Time;
import java.util.List;
import java.util.Map;

/**
 * Created by lipen on 2018/1/8.
 */
public class RouteMngAction {
    private int rid;
    private int stationA;
    private int stationB;
    private double distance;
    private Time time;
    private double businessClass;
    private Double firstClass;
    private Double secondClass;
    private RouteManagerServerImpl routeManagerServer = new RouteManagerServerImpl();

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getStationA() {
        return stationA;
    }

    public void setStationA(int stationA) {
        this.stationA = stationA;
    }

    public int getStationB() {
        return stationB;
    }

    public void setStationB(int stationB) {
        this.stationB = stationB;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public double getBusinessClass() {
        return businessClass;
    }

    public void setBusinessClass(double businessClass) {
        this.businessClass = businessClass;
    }

    public Double getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(Double firstClass) {
        this.firstClass = firstClass;
    }

    public Double getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(Double secondClass) {
        this.secondClass = secondClass;
    }

    private RouteEntity setRouteEntity() {
        RouteEntity routeEntity = new RouteEntity();
        routeEntity.setRid(this.getRid());//主键
        routeEntity.setBusinessClass(this.getBusinessClass());
        routeEntity.setDistance(this.getDistance());
        routeEntity.setFirstClass(this.getFirstClass());
        routeEntity.setSecondClass(this.getSecondClass());
        routeEntity.setStationA(this.getStationA());
        routeEntity.setStationB(this.getStationB());
        routeEntity.setTime(this.getTime());
        return routeEntity;
    }

    public String List() throws Exception {
        List<RouteEntity> list = routeManagerServer.ListRoute();
        if (list != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("RouteList", list);
            return "success";
        } else
            return "fail";
    }

    public String Update() throws Exception {
        RouteEntity routeEntity = this.setRouteEntity();
        if (routeManagerServer.UpdateRoute(routeEntity)) {
            return "success";
        } else {
            return "fail";
        }
    }

    public String Add() throws Exception {
        RouteEntity routeEntity = this.setRouteEntity();
        if (routeManagerServer.AddRoute(routeEntity)) {
            return "success";
        } else {
            return "fail";
        }
    }

    public String Delete() throws Exception {
        RouteEntity routeEntity = this.setRouteEntity();
        if (routeManagerServer.DeleteRoute(routeEntity)) {
            return "success";
        } else {
            return "fail";
        }
    }

    public String findRouteById() throws Exception {
        int id = this.getRid();
        RouteEntity routeEntity = routeManagerServer.findRouteById(id);
        if (routeEntity != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("routeEntity", routeEntity);
            return "success";
        } else
            return "fail";
    }
}
