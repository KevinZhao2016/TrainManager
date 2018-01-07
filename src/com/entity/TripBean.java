package com.entity;

import java.sql.Time;

public class TripBean {
    private String Tname;//列车号
    private Double BusinessClassPrice;//商务座价格
    private Double FirstClassPrice;//一等座价格
    private Double SecondClassPrice;//二等座价格
    private Time DepartureTime;//本列车上车时间
    private Time ArrivalTime;//本列车到达时间
    private Time TripTime;//本列车乘坐时间
    private String DepartureStation;//本列车上车站
    private String ArrivalStation;//本列车下车站

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public Time getTripTime() {
        return TripTime;
    }

    public void setTripTime(Time tripTime) {
        TripTime = tripTime;
    }

    public Double getBusinessClassPrice() {
        return BusinessClassPrice;
    }

    public void setBusinessClassPrice(Double businessClassPrice) {
        BusinessClassPrice = businessClassPrice;
    }

    public Double getFirstClassPrice() {
        return FirstClassPrice;
    }

    public void setFirstClassPrice(Double firstClassPrice) {
        FirstClassPrice = firstClassPrice;
    }

    public Double getSecondClassPrice() {
        return SecondClassPrice;
    }

    public void setSecondClassPrice(Double secondClassPrice) {
        SecondClassPrice = secondClassPrice;
    }

    public Time getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(Time departureTime) {
        DepartureTime = departureTime;
    }

    public Time getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        ArrivalTime = arrivalTime;
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
}
