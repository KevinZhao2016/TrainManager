package com.service;

import com.entity.StationEntity;

import java.util.List;

/**
 * Created by lipen on 2018/1/8.
 */
public interface StationManageServer {
    List ListStation();

    Boolean UpdateStation(StationEntity stationEntity);

    Boolean AddStation(StationEntity stationEntity);

    Boolean DeleteStation(int id);

    StationEntity findStationById(int id);
}
