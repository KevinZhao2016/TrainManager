package com.dao;


import com.model.TripsEntity;

import java.util.List;

public interface TripsDao {
    List ListTrips();

    Boolean UpdateTrips(TripsEntity tripsEntity);

    Boolean AddTrips(TripsEntity tripsEntity);

    Boolean DeleteTrips(TripsEntity tripsEntity);

    TripsEntity findTripsById(int tid);
}