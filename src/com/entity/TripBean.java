package com.entity;

import java.sql.Time;

public class TripBean {
    private String Tname;
    private Double BusinessClassPrice;
    private Double FirstClassPrice;
    private Double SecondClassPrice;
    private Time DepartureTime;
    private Time ArrivalTime;
    private Time TripTime;
    private String DepartureStation;
    private String ArrivalStation;

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
