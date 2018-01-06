package com.service;

import com.entity.QueryResult;
import com.entity.StationEntity;
import com.entity.TripsEntity;

import java.util.List;

public interface QureyTripsServer {
    List<QueryResult>getDirectPath(String StationA,String StationB);
    List<QueryResult>getTransferPath(String StationA,String StationB);
}
