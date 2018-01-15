package com.service;

import com.entity.RouteEntity;

import java.util.List;

/**
 * Created by lipen on 2018/1/8.
 */
public interface RouteManageServer {
    List ListRoute();

    Boolean UpdateRoute(RouteEntity routeEntity);

    Boolean AddRoute(RouteEntity routeEntity);

    Boolean DeleteRoute(int id);

    RouteEntity findRouteById(int id);
}
