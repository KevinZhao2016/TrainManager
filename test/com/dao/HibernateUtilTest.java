package com.dao;

import com.entity.RouteEntity;
import com.entity.StationEntity;
import com.entity.UsersEntity;
import org.junit.Test;

import java.util.List;

public class HibernateUtilTest {
    private HibernateUtil util = new HibernateUtil();

    @Test
    public void ListUser() {
        List<UsersEntity> list = util.ListUser();
        for (UsersEntity stu : list) {
            System.out.print(stu.getId() + " ");
            System.out.println(stu.getName());
        }
    }

    @Test
    public void Login() {
        System.out.println(util.Login("13396681253","123456"));
    }

    @Test
    public void listStation() {
        List<StationEntity> list = util.ListStation();
        for (StationEntity station : list) {
//            System.out.print(station.getId() + " ");
//            System.out.print(station.getName() + " ");
//            System.out.println(station.getPinyin() + " ");
            if (station.getPinyin().contains("dong")){
                System.out.println(station.getName());
            }
        }
    }

    @Test
    public void listRoute() {
        List<RouteEntity> list = util.ListRoute();
        for (RouteEntity route : list) {
            System.out.print(route.getRid() + " ");
            System.out.print(route.getStationA() + " ");
            System.out.print(route.getDistance() + " ");
            System.out.println(route.getStationB() + " ");
        }
    }

    @Test
    public void listTrips() {
        String s = ",1,2,3,4,54,";
        String[] t = s.split(",");
        for(String str: t){
            System.out.println(str);

        }
        System.out.println(t.length);
    }
}