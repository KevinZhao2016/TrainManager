package com.service;

import com.model.QueryResult;

import java.util.List;

public interface QureyTripsServer {
    List<QueryResult>getDirectPath(String StationA,String StationB);
    List<QueryResult>getTransferPath(String StationA,String StationB);
}
