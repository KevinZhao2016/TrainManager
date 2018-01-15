package com.service.impl;

import com.dao.impl.RouteDaoImpl;
import com.entity.RouteEntity;
import com.service.RouteManageServer;

import java.util.ArrayList;
import java.util.List;

public class RouteManagerServerImpl implements RouteManageServer {
    private RouteDaoImpl routeDao = new RouteDaoImpl();

    @Override
    public List ListRoute() {
        List<RouteEntity> list;
        list = routeDao.ListRoute();
        return list;
    }

    @Override
    public Boolean UpdateRoute(RouteEntity routeEntity) {
        return routeDao.UpdateRoute(routeEntity);
    }

    @Override
    public Boolean AddRoute(RouteEntity routeEntity) {
        return routeDao.AddRoute(routeEntity);
    }

    @Override
    public Boolean DeleteRoute(int id) {
        RouteEntity routeEntity = findRouteById(id);
        return routeDao.DeleteRoute(routeEntity);
    }

    @Override
    public RouteEntity findRouteById(int id) {
        return routeDao.findRouteById(id);
    }
}
