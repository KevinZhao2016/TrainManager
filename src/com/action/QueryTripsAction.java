package com.action;

import com.entity.QueryResult;
import com.entity.TransferBean;
import com.service.impl.PathSearchServerImpl;
import com.service.impl.QueryTripsServerImpl;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class QueryTripsAction {
    private Time DepartureTime;
    private String DepartureStation;
    private String ArrivalStation;
    private QueryResult queryResult = new QueryResult();

    public QueryResult getQueryResult() {
        return queryResult;
    }

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

    public String execute() throws Exception {
        QueryResult queryResult = new QueryResult();
        PathSearchServerImpl pathSearchServer = new PathSearchServerImpl();
        QueryTripsServerImpl queryTripsServer = new QueryTripsServerImpl();
        queryResult.setArrivalStation(getArrivalStation());
        queryResult.setDepartureStation(getDepartureStation());
        queryResult.setDepartureTime(getDepartureTime());
        queryResult.setArrivalTime(new Time(2,30,0));

        List<TransferBean> TransferList = new ArrayList<TransferBean>();
        queryResult.setTransferList(TransferList);
        return "success";
    }
}
