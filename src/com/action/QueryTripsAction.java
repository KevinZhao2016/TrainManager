package com.action;

import com.model.QueryResult;
import com.opensymphony.xwork2.ActionContext;
import com.service.impl.QueryTripsServerImpl;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class QueryTripsAction {
    private Time DepartureTime;
    private String DepartureStation;
    private String ArrivalStation;
    private int Type;
    private List<QueryResult> queryResults;

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

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public List<QueryResult> getQueryResults() {
        return queryResults;
    }

    public void setQueryResults(List<QueryResult> queryResults) {
        this.queryResults = queryResults;
    }

    public String execute() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        List<QueryResult> queryResultList;
        QueryTripsServerImpl queryTripsServer = new QueryTripsServerImpl();
        queryResultList = queryTripsServer.getDirectPath(getDepartureStation(), getArrivalStation());
        //查找直达车
        if (queryResultList.size() == 0) {
            //未找到直达车，搜索换乘车次
            queryResultList = queryTripsServer.getTransferPath(getDepartureStation(), getArrivalStation());
            if (queryResultList.size() == 0){
                //均未找到
                session.put("Type",0);
                return "fail";
            }else{
                //找到换乘车次
                setQueryResults(queryResultList);
                session.put("queryResultList", queryResultList);
                session.put("Type",2);
                return "fail";
            }
        }else{
            //找到直达车
            setQueryResults(queryResultList);
            session.put("queryResultList", queryResultList);
            session.put("Type", 1);
            return "success";
        }
    }
}
