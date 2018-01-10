package com.service.impl;

import com.dao.StationDao;
import com.dao.impl.StationDaoImpl;
import com.entity.StationEntity;
import com.service.StationManageServer;

import java.util.ArrayList;
import java.util.List;

public class StationManagerServerImpl implements StationManageServer {
    private StationDao stationDao = new StationDaoImpl();

    @Override
    public List ListStation() {
        List<StationEntity> list;
        list = stationDao.ListStation();
        return list;
    }

    @Override
    public Boolean UpdateStation(StationEntity stationEntity) {
        return stationDao.UpdateStation(stationEntity);
    }

    @Override
    public Boolean AddStation(StationEntity stationEntity) {
        return stationDao.AddStation(stationEntity);
    }

    @Override
    public Boolean DeleteStation(StationEntity stationEntity) {
        return stationDao.DeleteStation(stationEntity);
    }

    @Override
    public StationEntity findStationById(int id) {
        return stationDao.findStationById(id);
    }
}
