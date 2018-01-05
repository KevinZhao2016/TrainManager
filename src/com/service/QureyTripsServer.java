package com.service;

import com.entity.StationEntity;
import com.entity.TripsEntity;

import java.util.List;

public interface QureyTripsServer {
    List<StationEntity> getTransferStation(List PathList);
    List<TripsEntity> getTrips(List PathList);
    Double getPrice(String StationA,String StationB,int Type);
}
