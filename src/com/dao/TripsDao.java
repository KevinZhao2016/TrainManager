package com.dao;


import com.entity.TripsEntity;

import java.util.List;

public interface TripsDao {
    List ListTrips();

    Boolean UpdateTrips(TripsEntity tripsEntity);

    Boolean AddTrips(TripsEntity tripsEntity);

    Boolean DeleteTrips(TripsEntity tripsEntity);

    TripsEntity findTripsById(int tid);
}