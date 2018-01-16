package com.service.impl;

import com.dao.impl.RouteDaoImpl;
import com.dao.impl.StationDaoImpl;
import com.dao.impl.TripsDaoImpl;
import com.model.*;
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

    //查找直达方案
    @Override
    public List<QueryResult> getDirectPath(String StationA, String StationB) {
        List<QueryResult> queryResultList = new ArrayList<>();
        if (StationA.equals(StationB)) {
            //保证出发站不等于终点站
            return queryResultList;
        }
        for (TripsEntity trip : tripsList) {
            String passby = trip.getPassby();
            String[] passByStations = passby.split(",");
            for (int i = 0; i < passByStations.length; i++) {
                if (StationA.equals(passByStations[i])) {
                    for (int j = i; j < passByStations.length; j++) {
                        if (StationB.equals(passByStations[j])) {
                            queryResultList.add(setQueryResult(StationA, StationB, trip));
                        }
                    }
                }
            }
        }
        return queryResultList;
    }

    //查找换乘车辆
    @Override
    public List<QueryResult> getTransferPath(String StationA, String StationB) {
        List<QueryResult> queryResultList = new ArrayList<>();
        for (StationEntity station : stationList) {
            //遍历每一个车站，作为中转站
            if (!station.getPinyin().equals(StationA) && !station.getPinyin().equals(StationB)) {
                List<QueryResult> firstQueryResultList = getDirectPath(StationA, station.getPinyin());
                List<QueryResult> secondQueryResultList = getDirectPath(station.getPinyin(), StationB);
                if (firstQueryResultList.size() != 0 || secondQueryResultList.size() != 0) {
                    int count = firstQueryResultList.size() < secondQueryResultList.size() ? firstQueryResultList.size() : secondQueryResultList.size();
                    QueryResult queryResult = new QueryResult();
                    List<TripBean> tripBeanList = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        QueryResult queryResultA = firstQueryResultList.get(i);
                        //第一辆车信息
                        QueryResult queryResultB = secondQueryResultList.get(i);
                        //第二辆车信息
                        TripBean tripBeanA = queryResultA.getTripBeans().get(0);
                        TripBean tripBeanB = queryResultB.getTripBeans().get(0);
                        tripBeanList.add(tripBeanA);
                        tripBeanList.add(tripBeanB);
                        //换乘方案总体信息
                        queryResult.setDepartureStation(getStationByPinyin(StationA).getName());//总出发站
                        queryResult.setArrivalStation(getStationByPinyin(StationB).getName());//总到达站
                        Time DepartureTime = tripBeanA.getDepartureTime();//总出发时间
                        queryResult.setDepartureTime(DepartureTime);
                        //总到达时间
                        Time ArrivalTime = CompareTime(tripBeanA.getArrivalTime(), tripBeanB.getArrivalTime()) ? tripBeanA.getArrivalTime() : tripBeanB.getArrivalTime();
                        queryResult.setArrivalTime(ArrivalTime);
                        //总二等座价格
                        queryResult.setTotalSecondClassPrice(tripBeanA.getSecondClassPrice() + tripBeanB.getSecondClassPrice());
                        //总时长
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

    //设置直达方案的具体信息
    private QueryResult setQueryResult(String StationA, String StationB, TripsEntity trip) {
        QueryResult queryResult = new QueryResult();
        List<TripBean> tripBeanList = new ArrayList<>();
        TripBean tripBean = new TripBean();//一辆车的信息
        tripBean.setTname(trip.getTname());
        tripBean.setDepartureStation(getStationByPinyin(StationA).getName());
        tripBean.setArrivalStation(getStationByPinyin(StationB).getName());
        //商务座价格
        tripBean.setBusinessClassPrice(getTripPrice(trip, StationA, StationB, 0));
        //一等座价格
        tripBean.setFirstClassPrice(getTripPrice(trip, StationA, StationB, 1));
        //二等座价格
        tripBean.setSecondClassPrice(getTripPrice(trip, StationA, StationB, 2));
        //出发时间
        Time departureTime = Timestamp2Time(trip.getDeparture());

        tripBean.setDepartureTime(departureTime);
        Time tripTime = getTripTime(trip, StationA, StationB);
        //乘坐本列车的时间
        tripBean.setTripTime(tripTime);
        //本列车下车时间
        Time arrivalTime = TimeAdd(departureTime, tripTime);
        tripBean.setArrivalTime(arrivalTime);
        tripBeanList.add(tripBean);
        //queryResult为本方案总体信息
        queryResult.setDepartureStation(getStationByPinyin(StationA).getName());
        queryResult.setArrivalStation(getStationByPinyin(StationB).getName());
        queryResult.setDepartureTime(tripBean.getDepartureTime());
        queryResult.setArrivalTime(tripBean.getArrivalTime());
        queryResult.setTotalSecondClassPrice(tripBean.getSecondClassPrice());
        queryResult.setTotalTime(tripBean.getTripTime());
        queryResult.setTripBeans(tripBeanList);

        return queryResult;
    }

    //根据起点终点获取价格，Type 0：商务座 1：一等座 2：二等座
    private Double getPrice(String StationA, String StationB, int Type) {
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

    //根据起点终点获得时间
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

    //根据起点终点和车次获得时间
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

    //根据起点终点和车次获得价格
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

    //两个Time相加
    private Time TimeAdd(Time TimeA, Time TimeB) {
        Time time = new Time(TimeA.getHours() + TimeB.getHours(), TimeA.getMinutes() + TimeB.getMinutes(), TimeA.getSeconds() + TimeB.getSeconds());
        return time;
    }

    //将Timestamp转换为Time
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

