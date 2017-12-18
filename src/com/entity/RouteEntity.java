package com.entity;

import java.sql.Time;
import java.util.Objects;

public class RouteEntity {
    private int rid;
    private int stationA;
    private int stationB;
    private double distance;
    private Time time;
    private double price;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getStationA() {
        return stationA;
    }

    public void setStationA(int stationA) {
        this.stationA = stationA;
    }

    public int getStationB() {
        return stationB;
    }

    public void setStationB(int stationB) {
        this.stationB = stationB;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteEntity that = (RouteEntity) o;
        return rid == that.rid &&
                stationA == that.stationA &&
                stationB == that.stationB &&
                Double.compare(that.distance, distance) == 0 &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rid, stationA, stationB, distance, time, price);
    }
}
