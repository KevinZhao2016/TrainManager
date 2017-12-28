package com.service;

import com.dao.HibernateUtil;
import com.dao.RouteDao;
import com.dao.StationDao;
import com.dao.TripsDao;
import com.entity.RouteEntity;
import com.entity.StationEntity;
import com.entity.TripsEntity;

import java.util.ArrayList;
import java.util.List;

public class PathSearchServer {
    private static StationDao stationDao = new StationDao();
    private static RouteDao routeDao = new RouteDao();
    private static TripsDao tripsDao = new TripsDao();
    private static final double INF = Double.POSITIVE_INFINITY;
    private static List<StationEntity> stationList = stationDao.ListStation();
    private static List<TripsEntity> tripsList = tripsDao.ListTrips();
    private static List<RouteEntity> routeList = routeDao.ListRoute();
    private double[][] distance = new double[stationList.size() + 1][stationList.size() + 1];

    private void initDistance() {
        for (int i = 0; i < stationList.size() + 1; i++) {
            for (int j = 0; j < stationList.size() + 1; j++) {
                if (i != j)
                    distance[i][j] = INF;
            }
        }
    }

    private StationEntity findStationByPinyin(String Pinyin) {
        for (StationEntity station : stationList) {
            if (station.getPinyin().equals(Pinyin)) {
                return station;
            }
        }
        return new StationEntity();
    }

    private double getInstanceById(int StationAID, int StationBID) {
        for (RouteEntity route : routeList) {
            if ((route.getStationA() == StationAID && route.getStationB() == StationBID) ||
                    (route.getStationA() == StationAID && route.getStationB() == StationBID)) {
                return route.getDistance();
            }
        }
        return INF;
    }

    private void setDistanceMatrix() {
        initDistance();
        for (TripsEntity trips : tripsList) {
            String passby = trips.getPassby();
            String[] passByStations = passby.split(",");
            for (int i = 1; i < passByStations.length - 1; i++) {
                int stationAID = findStationByPinyin(passByStations[i]).getId();
                int stationBID = findStationByPinyin(passByStations[i + 1]).getId();
                double dis = getInstanceById(stationAID, stationBID);
                distance[stationAID][stationBID] = dis;
            }
        }
    }

    private List DFS(String StationA, String StationB){
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();

        return paths;
    }

}
