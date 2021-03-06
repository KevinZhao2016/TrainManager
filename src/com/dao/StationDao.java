package com.dao;

import com.model.StationEntity;

import java.util.List;

public interface StationDao {
    List ListStation();

    Boolean UpdateStation(StationEntity stationEntity);

    Boolean AddStation(StationEntity stationEntity);

    Boolean DeleteStation(StationEntity stationEntity);

    StationEntity findStationById(int id);
}