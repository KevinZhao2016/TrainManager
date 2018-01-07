package com.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class QueryResult {
    private Time DepartureTime;//总出发时间
    private String DepartureStation;//总出发站
    private String ArrivalStation;//总到达站
    private String TransferStation;//换乘站
    private Time TotalTime;//总时间
    private Time ArrivalTime;//总到达时间
    private Double TotalSecondClassPrice;//总二等座价格
    private List<TripBean> tripBeans = new ArrayList<>();//本方案中每辆车的信息

    public Time getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(Time departureTime) {
        DepartureTime = departureTime;
    }

    public String getDepartureStation() {
        return DepartureStation;
    }

    public void setDepartureStation(String departureStation) {
        DepartureStation = departureStation;
    }

    public String getArrivalStation() {
        return ArrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        ArrivalStation = arrivalStation;
    }

    public Time getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(Time totalTime) {
        TotalTime = totalTime;
    }

    public Time getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public Double getTotalSecondClassPrice() {
        return TotalSecondClassPrice;
    }

    public void setTotalSecondClassPrice(Double totalSecondClassPrice) {
        TotalSecondClassPrice = totalSecondClassPrice;
    }

    public List<TripBean> getTripBeans() {
        return tripBeans;
    }

    public void setTripBeans(List<TripBean> tripBeans) {
        this.tripBeans = tripBeans;
    }

    public String getTransferStation() {
        return TransferStation;
    }

    public void setTransferStation(String transferStation) {
        TransferStation = transferStation;
    }
}
