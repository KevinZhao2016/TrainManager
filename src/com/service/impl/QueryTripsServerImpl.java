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
        if (StationA.equals(StationB)) {
            return queryResultList;
        }
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

                            tripBean.setBusinessClassPrice(getTripPrice(trip, StationA, StationB, 0));
                            tripBean.setFirstClassPrice(getTripPrice(trip, StationA, StationB, 1));
                            tripBean.setSecondClassPrice(getTripPrice(trip, StationA, StationB, 2));

                            Time departureTime = Timestamp2Time(trip.getDeparture());
                            tripBean.setDepartureTime(departureTime);
                            Time tripTime = getTripTime(trip, StationA, StationB);
                            tripBean.setTripTime(tripTime);
                            Time arrivalTime = TimeAdd(departureTime, tripTime);
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
        for (StationEntity station : stationList) {
            if (!station.getPinyin().equals(StationA) && !station.getPinyin().equals(StationB)) {
                List<QueryResult> firstQueryResultList = getDirectPath(StationA, station.getPinyin());
                List<QueryResult> secondQueryResultList = getDirectPath(station.getPinyin(), StationB);
                if (firstQueryResultList.size() != 0 || secondQueryResultList.size() != 0) {
                    int count = firstQueryResultList.size() < secondQueryResultList.size() ? firstQueryResultList.size() : secondQueryResultList.size();
                    QueryResult queryResult = new QueryResult();
                    List<TripBean> tripBeanList = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        QueryResult queryResultA = firstQueryResultList.get(i);
                        QueryResult queryResultB = secondQueryResultList.get(i);
                        TripBean tripBeanA = queryResultA.getTripBeans().get(0);
                        TripBean tripBeanB = queryResultB.getTripBeans().get(0);
                        tripBeanList.add(tripBeanA);
                        tripBeanList.add(tripBeanB);

                        queryResult.setDepartureStation(StationA);
                        queryResult.setArrivalStation(StationB);
                        Time DepartureTime = CompareTime(tripBeanA.getDepartureTime(), tripBeanB.getDepartureTime()) ? tripBeanB.getDepartureTime() : tripBeanA.getDepartureTime();
                        queryResult.setDepartureTime(DepartureTime);
                        Time ArrivalTime = CompareTime(tripBeanA.getDepartureTime(), tripBeanB.getDepartureTime()) ? tripBeanA.getDepartureTime() : tripBeanB.getDepartureTime();
                        queryResult.setArrivalTime(ArrivalTime);

                        queryResult.setTotalSecondClassPrice(tripBeanA.getSecondClassPrice() + tripBeanB.getSecondClassPrice());
                        queryResult.setTotalTime(TimeAdd(tripBeanA.getTripTime(), tripBeanB.getTripTime()));
                        queryResult.setTripBeans(tripBeanList);
                        queryResult.setTransferStation(station.getName());//换乘站名
                        queryResultList.add(queryResult);
                    }

                }
            }

        }

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

    private TripsEntity getTripsByTname(String name) {
        for (TripsEntity trip : tripsList) {
            if (trip.getTname() == name) {
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

    private Time getTripTime(TripsEntity tripsEntity, String StationA, String StationB) {
        Time time = new Time(0, 0, 0);
        int index = 0;
        String passby = tripsEntity.getPassby();
        String[] passByStations = passby.split(",");
        for (int i = 1; i < passByStations.length; i++) {
            if (passByStations[i].equals(StationA)) {
                index = i;
                break;
            }
        }
        for (int i = index; !passByStations[i].equals(StationB); i++) {
            time = TimeAdd(time, getTimeByPinyin(passByStations[i], passByStations[i + 1]));
        }
        return time;
    }

    private Double getTripPrice(TripsEntity tripsEntity, String StationA, String StationB, int Type) {
        double price = 0;
        int index = 0;
        String passby = tripsEntity.getPassby();
        String[] passByStations = passby.split(",");
        for (int i = 1; i < passByStations.length; i++) {
            if (passByStations[i].equals(StationA)) {
                index = i;
                break;
            }
        }
        for (int i = index; !passByStations[i].equals(StationB); i++) {
            price += getPrice(passByStations[i], passByStations[i + 1], Type);
        }
        return price;
    }

    private Time TimeAdd(Time TimeA, Time TimeB) {
        Time time = new Time(TimeA.getHours() + TimeB.getHours(), TimeA.getMinutes() + TimeB.getMinutes(), TimeA.getSeconds() + TimeB.getSeconds());
        return time;
    }

    private Time Timestamp2Time(Timestamp timestamp) {
        int Seconds = timestamp.getSeconds();
        int Minutes = timestamp.getMinutes();
        int Hours = timestamp.getHours();
        Time time = new Time(Hours, Minutes, Seconds);
        return time;
    }

    //比较两个时间，A>B返回True
    private Boolean CompareTime(Time TimeA, Time TimeB) {
        if (TimeA.getHours() > TimeB.getHours()) {
            return true;
        } else if (TimeA.getHours() == TimeB.getHours()) {
            if (TimeA.getMinutes() > TimeB.getMinutes()) {
                return true;
            } else if (TimeA.getMinutes() == TimeB.getMinutes()) {
                if (TimeA.getSeconds() > TimeB.getSeconds()) {
                    return true;
                }
            }
        }
        return false;
    }
}

