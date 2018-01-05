package com.service.impl;

import com.dao.impl.RouteDaoImpl;
import com.dao.impl.StationDaoImpl;
import com.dao.impl.TripsDaoImpl;
import com.entity.RouteEntity;
import com.entity.StationEntity;
import com.entity.TripsEntity;
import com.service.QureyTripsServer;

import java.util.ArrayList;
import java.util.List;

public class QueryTripsServerImpl implements QureyTripsServer{
    private static StationDaoImpl stationDaoImpl = new StationDaoImpl();
    private static TripsDaoImpl tripsDaoImpl = new TripsDaoImpl();
    private static RouteDaoImpl routeDaoImpl = new RouteDaoImpl();
    private static List<StationEntity> stationList = stationDaoImpl.ListStation();
    private static List<TripsEntity> tripsList = tripsDaoImpl.ListTrips();
    private static List<RouteEntity> routeList = routeDaoImpl.ListRoute();

    @Override
    public List<StationEntity> getTransferStation(List PathList){
        List<StationEntity> list = new ArrayList<StationEntity>();

        StationEntity station = getStationByPinyin("ningbo");
        list.add(station);
        station = getStationByPinyin("dezhoudong");
        list.add(station);
        return list;
    }
    @Override
    public List<TripsEntity> getTrips(List PathList){
        List<TripsEntity> list = new ArrayList<TripsEntity>();

        TripsEntity trips = getTripsById(2);
        list.add(trips);
        trips = getTripsById(5);
        list.add(trips);
        return list;
    }
    @Override
    public Double getPrice(String StationA,String StationB,int Type){
        StationEntity stationA = getStationByPinyin(StationA);
        StationEntity stationB = getStationByPinyin(StationB);
        for (RouteEntity route : routeList) {
            if ((route.getStationA() == stationA.getId() && route.getStationB() == stationB.getId()) ||
                    (route.getStationB() == stationA.getId() && route.getStationA() == stationB.getId())   ) {
                switch (Type){
                    case 0: return route.getBusinessClass();
                    case 1: return route.getFirstClass();
                    case 2: return route.getSecondClass();
                    default: return 0.0;
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
}

