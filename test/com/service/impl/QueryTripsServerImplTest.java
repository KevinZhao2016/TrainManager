package com.service.impl;

import com.entity.QueryResult;
import com.entity.TripBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QueryTripsServerImplTest {
    private QueryTripsServerImpl queryTripsServer = new QueryTripsServerImpl();

    @Test
    public void getDirectPath() {
        List<QueryResult> queryResultList = new ArrayList<>();
        queryResultList = queryTripsServer.getDirectPath("ningbo", "hangzhoudong");
        for (QueryResult queryResult : queryResultList) {
            System.out.print(queryResult.getDepartureStation()+" ");
            System.out.print(queryResult.getDepartureTime()+" ");
            System.out.print(queryResult.getArrivalStation()+" ");
            System.out.print(queryResult.getArrivalTime()+" ");
            System.out.print(queryResult.getTotalTime()+" ");
            System.out.print(queryResult.getTotalSecondClassPrice()+" ");
            List<TripBean> tripBeans = queryResult.getTripBeans();
            for (TripBean tripBean : tripBeans) {
                System.out.print(tripBean.getTname()+" ");
            }
            System.out.println();
        }
    }


    @Test
    public void getTransferPath() {
        List<QueryResult> queryResultList = new ArrayList<>();
        queryResultList = queryTripsServer.getTransferPath("ningbo", "jinan");
        System.out.println(queryResultList.size());
        for (QueryResult queryResult : queryResultList) {
            System.out.print(queryResult.getDepartureStation()+" ");
            System.out.print(queryResult.getDepartureTime()+" ");
            System.out.print(queryResult.getArrivalStation()+" ");
            System.out.print(queryResult.getArrivalTime()+" ");
            System.out.print(queryResult.getTotalTime()+" ");
            System.out.print(queryResult.getTotalSecondClassPrice()+" ");
            List<TripBean> tripBeans = queryResult.getTripBeans();
            for (TripBean tripBean : tripBeans) {
                System.out.print(tripBean.getTname()+" ");
            }
            System.out.println();
        }
    }
}