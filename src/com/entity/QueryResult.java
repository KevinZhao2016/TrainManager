package com.entity;

import java.sql.Time;
import java.util.List;

public class QueryResult {
    private Time DepartureTime;
    private Time ArrivalTime;
    private String DepartureStation;
    private String ArrivalStation;
    private List<TransferBean> TransferList;

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

    public List<TransferBean> getTransferList() {
        return TransferList;
    }

    public void setTransferList(List<TransferBean> transferList) {
        TransferList = transferList;
    }
}
