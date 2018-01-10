package com.dao;

import com.entity.RouteEntity;

import java.util.List;

public interface RouteDao {
    List ListRoute();

    Boolean UpdateRoute(RouteEntity routeEntity);

    Boolean AddRoute(RouteEntity routeEntity);

    Boolean DeleteRoute(RouteEntity routeEntity);

    RouteEntity findRouteById(int id);
}
