package com.service.impl;

import com.dao.impl.TripsDaoImpl;
import com.entity.TripsEntity;
import com.service.TripManageServer;

import java.util.List;

public class TripManagerServerImpl implements TripManageServer {
    private TripsDaoImpl tripsDao = new TripsDaoImpl();

    @Override
    public List ListTrips() {
        List<TripsEntity> list;
        list = tripsDao.ListTrips();
        return list;
    }

    @Override
    public Boolean UpdateTrips(TripsEntity tripsEntity) {
        return tripsDao.UpdateTrips(tripsEntity);
    }

    @Override
    public Boolean AddTrips(TripsEntity tripsEntity) {
        return tripsDao.AddTrips(tripsEntity);
    }

    @Override
    public Boolean DeleteTrips(int id) {
        TripsEntity tripsEntity = findTripsById(id);
        return tripsDao.DeleteTrips(tripsEntity);
    }

    @Override
    public TripsEntity findTripsById(int tid) {
        return tripsDao.findTripsById(tid);
    }
}
