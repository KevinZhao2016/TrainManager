package com.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class QueryResult {
    private Time DepartureTime;
    private String DepartureStation;
    private String ArrivalStation;
    private String TransferStation;
    private Time TotalTime;
    private Time ArrivalTime;
    private Double TotalSecondClassPrice;
    private List<TripBean> tripBeans = new ArrayList<>();

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
