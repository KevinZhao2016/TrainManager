package com.service;

import com.entity.TripsEntity;

import java.util.List;

/**
 * Created by lipen on 2018/1/8.
 */
public interface TripManageServer {
    List ListTrips();

    Boolean UpdateTrips(TripsEntity tripsEntity);

    Boolean AddTrips(TripsEntity tripsEntity);

    Boolean DeleteTrips(int id);

    TripsEntity findTripsById(int tid);
}
