package com.service.impl;

import com.dao.impl.RouteDaoImpl;
import com.dao.impl.StationDaoImpl;
import com.dao.impl.TripsDaoImpl;
import com.entity.*;
import com.service.QureyTripsServer;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class QueryTripsServerImpl implements QureyTripsServer {
    private static StationDaoImpl stationDaoImpl = new StationDaoImpl();
    private static TripsDaoImpl tripsDaoImpl = new TripsDaoImpl();
    private static RouteDaoImpl routeDaoImpl = new RouteDaoImpl();
    private static List<StationEntity> stationList = stationDaoImpl.ListStation();
    private static List<TripsEntity> tripsList = tripsDaoImpl.ListTrips();
    private static List<RouteEntity> routeList = routeDaoImpl.ListRoute();


    @Override
    public List<QueryResult> getDirectPath(String StationA, String StationB) {
        List<QueryResult> queryResultList = new ArrayList<>();

        for (TripsEntity trip : tripsList) {
            String passby = trip.getPassby();
            String[] passByStations = passby.split(",");
            for (int i = 0; i < passByStations.length; i++) {
                if (StationA.equals(passByStations[i])) {
                    for (int j = i; j < passByStations.length; j++) {
                        if (StationB.equals(passByStations[j])) {
                            QueryResult queryResult = new QueryResult();
                            List<TripBean> tripBeanList = new ArrayList<>();
                            TripBean tripBean = new TripBean();
                            tripBean.setTname(trip.getTname());
                            tripBean.setDepartureStation(StationA);
                            tripBean.setArrivalStation(StationB);
                            tripBean.setBusinessClassPrice(getPrice(StationA, StationB, 0));
                            tripBean.setFirstClassPrice(getPrice(StationA, StationB, 1));
                            tripBean.setSecondClassPrice(getPrice(StationA, StationB, 2));
                            Time departureTime = Timestamp2Time(trip.getDeparture());
                            tripBean.setDepartureTime(departureTime);
                            Time tripTime = getTimeByPinyin(StationA,StationB);
                            tripBean.setTripTime(tripTime);
                            Time arrivalTime = TimeAdd(departureTime,tripTime);
                            tripBean.setArrivalTime(arrivalTime);

                            tripBeanList.add(tripBean);
                            queryResult.setDepartureStation(StationA);
                            queryResult.setArrivalStation(StationB);
                            queryResult.setDepartureTime(tripBean.getDepartureTime());
                            queryResult.setArrivalTime(tripBean.getArrivalTime());
                            queryResult.setTotalSecondClassPrice(tripBean.getSecondClassPrice());
                            queryResult.setTotalTime(tripBean.getTripTime());
                            queryResult.setTripBeans(tripBeanList);
                            queryResultList.add(queryResult);

                        }
                    }
                }
            }
        }
        return queryResultList;
    }

    @Override
    public List<QueryResult> getTransferPath(String StationA, String StationB) {
        List<QueryResult> queryResultList = new ArrayList<>();
        return queryResultList;
    }


    public List<StationEntity> getTransferStation(List PathList) {
        List<StationEntity> list = new ArrayList<StationEntity>();

        StationEntity station = getStationByPinyin("ningbo");
        list.add(station);
        station = getStationByPinyin("dezhoudong");
        list.add(station);
        return list;
    }


    public List<TripsEntity> getTrips(List PathList) {
        List<TripsEntity> list = new ArrayList<TripsEntity>();

        TripsEntity trips = getTripsById(2);
        list.add(trips);
        trips = getTripsById(5);
        list.add(trips);
        return list;
    }

    public Double getPrice(String StationA, String StationB, int Type) {
        StationEntity stationA = getStationByPinyin(StationA);
        StationEntity stationB = getStationByPinyin(StationB);
        for (RouteEntity route : routeList) {
            if ((route.getStationA() == stationA.getId() && route.getStationB() == stationB.getId()) ||
                    (route.getStationB() == stationA.getId() && route.getStationA() == stationB.getId())) {
                switch (Type) {
                    case 0:
                        return route.getBusinessClass();
                    case 1:
                        return route.getFirstClass();
                    case 2:
                        return route.getSecondClass();
                    default:
                        return 0.0;
                }
            }
        }
        return 0.0;
    }

    private StationEntity getStationByPinyin(String Pinyin) {
        for (StationEntity station : stationList) {
            if (station.getPinyin().equals(Pinyin)) {
                return station;
            }
        }
        return new StationEntity();
    }

    private TripsEntity getTripsById(int tid) {
        for (TripsEntity trip : tripsList) {
            if (trip.getTid() == tid) {
                return trip;
            }
        }
        return new TripsEntity();
    }

    private Time getTimeByPinyin(String StationA, String StationB) {
        StationEntity stationA = getStationByPinyin(StationA);
        StationEntity stationB = getStationByPinyin(StationB);
        for (RouteEntity route : routeList) {
            if ((route.getStationA() == stationA.getId() && route.getStationB() == stationB.getId()) ||
                    (route.getStationB() == stationA.getId() && route.getStationA() == stationB.getId())) {
                Time time = route.getTime();
                return time;
            }
        }
        return new Time(0, 0, 0);
    }

    private Time TimeAdd(Time TimeA, Time TimeB) {
        Time time = new Time(TimeA.getHours() + TimeB.getHours(), TimeA.getMinutes() + TimeB.getMinutes(), TimeA.getSeconds() + TimeB.getSeconds());
        return time;
    }

    private Time Timestamp2Time(Timestamp timestamp){
        int Seconds = timestamp.getSeconds();
        int Minutes = timestamp.getMinutes();
        int Hours = timestamp.getHours();
        Time time = new Time(Hours,Minutes,Seconds);
        return time;
    }
}

