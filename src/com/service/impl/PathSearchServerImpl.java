package com.service.impl;

import com.dao.impl.RouteDaoImpl;
import com.dao.impl.StationDaoImpl;
import com.dao.impl.TripsDaoImpl;
import com.entity.RouteEntity;
import com.entity.StationEntity;
import com.entity.TripsEntity;
import com.service.PathSearchServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSearchServerImpl implements PathSearchServer {
    private static StationDaoImpl stationDaoImpl = new StationDaoImpl();
    private static RouteDaoImpl routeDaoImpl = new RouteDaoImpl();
    private static TripsDaoImpl tripsDaoImpl = new TripsDaoImpl();
    private static final double INF = Double.POSITIVE_INFINITY;
    private static List<StationEntity> stationList = stationDaoImpl.ListStation();
    private static List<TripsEntity> tripsList = tripsDaoImpl.ListTrips();
    private static List<RouteEntity> routeList = routeDaoImpl.ListRoute();
    private int N = stationList.size() + 1;
    private double[][] distance = new double[N][N];


    private void initDistance() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
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

    private double getDistanceById(int StationAID, int StationBID) {
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
                int stationAId = findStationByPinyin(passByStations[i]).getId();
                int stationBId = findStationByPinyin(passByStations[i + 1]).getId();
                double dis = getDistanceById(stationAId, stationBId);
                distance[stationAId][stationBId] = dis;
            }
        }
    }

    private List DFS(int StationAId, int StationBId) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        int N = stationList.size() + 1;
        Boolean[] visited = new Boolean[N];
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < N; i++) {
            visited[i] = false;
        }

        s.add(StationAId);
        do {

            // 出栈
            int curr = s.pop();
            // 如果该节点还没有被遍历，则遍历该节点并将子节点入栈
            if (!visited[curr]) {
                // 遍历并打印
                path.add(curr);
                System.out.println(curr);
                visited[curr] = true;
                // 没遍历的子节点入栈
                for (int j = N - 1; j >= 0; j--) {
                    if (distance[curr][j] != INF && !visited[j]) {
                        s.add(j);
                    }
                }
            }
        } while (!s.isEmpty());
        return paths;
    }

    @Override
    public List getPaths(String StationA, String StationB) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        setDistanceMatrix();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

        DFS(1, 4);
        return paths;
    }

}
