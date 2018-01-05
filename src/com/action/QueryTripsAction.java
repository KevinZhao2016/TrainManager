package com.action;

import com.entity.QueryResult;
import com.service.impl.PathSearchServerImpl;
import com.service.impl.QueryTripsServerImpl;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class QueryTripsAction {
    private Time DepartureTime;
    private String DepartureStation;
    private String ArrivalStation;
    private Time TotalTime;
    private Time ArrivalTime;
    private Double TotalSecondClassPrice;
    private List<QueryResult> queryResult;

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

    public List<QueryResult> getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(List<QueryResult> queryResult) {
        this.queryResult = queryResult;
    }

    public String execute() throws Exception {
        QueryResult result = new QueryResult();
        List<QueryResult> queryResult = new ArrayList<QueryResult>();
        PathSearchServerImpl pathSearchServer = new PathSearchServerImpl();
        QueryTripsServerImpl queryTripsServer = new QueryTripsServerImpl();

        result.setArrivalTime(new Time(2,30,0));
        result.setDepartureTime(new Time(1,30,0));
        result.setArrivalStation("dezhoudong");
        result.setDepartureStation("hangzhoudong");
        result.setBusinessClassPrice(1888.0);
        result.setSecondClassPrice(999.9);
        result.setFirstClassPrice(1000.0);
        result.setTname("D111");
        queryResult.add(result);
        queryResult.add(result);
        setTotalTime(new Time(2,30,0));
        setArrivalTime(new Time(8,45,0));
        setTotalSecondClassPrice(888.0);
        setQueryResult(queryResult);

        return "success";
    }
}
