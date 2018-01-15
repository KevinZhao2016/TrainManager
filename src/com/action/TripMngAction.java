package com.action;

import com.entity.TripsEntity;
import com.opensymphony.xwork2.ActionContext;
import com.service.impl.TripManagerServerImpl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by lipen on 2018/1/8.
 */
public class TripMngAction {
    private int tid;
    private String tname;
    private String passby;
    private Timestamp departure;
    private Integer ttype;
    private TripManagerServerImpl tripManagerServer = new TripManagerServerImpl();

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPassby() {
        return passby;
    }

    public void setPassby(String passby) {
        this.passby = passby;
    }

    public Timestamp getDeparture() {
        return departure;
    }

    public void setDeparture(Timestamp departure) {
        this.departure = departure;
    }

    public Integer getTtype() {
        return ttype;
    }

    public void setTtype(Integer ttype) {
        this.ttype = ttype;
    }

    private TripsEntity setTripsEntity() {
        TripsEntity tripsEntity = new TripsEntity();
        tripsEntity.setDeparture(this.getDeparture());
        tripsEntity.setPassby(this.getPassby());
        tripsEntity.setTid(this.getTid());
        tripsEntity.setTname(this.getTname());
        tripsEntity.setTtype(this.getTtype());
        return tripsEntity;
    }

    public String List() throws Exception {
        List<TripsEntity> list = tripManagerServer.ListTrips();
        if (list != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("TripList", list);
            return "success";
        } else
            return "fail";
    }

    public String Update() throws Exception {
        TripsEntity tripsEntity = this.setTripsEntity();
        if (tripManagerServer.UpdateTrips(tripsEntity)) {
            this.List();
            return "success";
        } else {
            return "fail";
        }
    }

    public String Add() throws Exception {
        TripsEntity tripsEntity = this.setTripsEntity();
        if (tripManagerServer.AddTrips(tripsEntity)) {
            this.List();
            return "success";
        } else {
            return "fail";
        }
    }

    public String Delete() throws Exception {
        TripsEntity tripsEntity = this.setTripsEntity();
        if (tripManagerServer.DeleteTrips(tripsEntity)) {
            this.List();
            return "success";
        } else {
            return "fail";
        }
    }

    public String findRouteById() throws Exception {
        int id = this.getTid();
        TripsEntity tripsEntity = tripManagerServer.findTripsById(id);
        if (tripsEntity != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("tripsEntity", tripsEntity);
            return "success";
        } else
            return "fail";
    }
}
