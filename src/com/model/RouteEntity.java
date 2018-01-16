package com.model;

import java.sql.Time;
import java.util.Objects;

public class RouteEntity {
    private int rid;
    private int stationA;
    private int stationB;
    private double distance;
    private Time time;
    private double businessClass;
    private Double firstClass;
    private Double secondClass;

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

    public double getBusinessClass() {
        return businessClass;
    }

    public void setBusinessClass(double businessClass) {
        this.businessClass = businessClass;
    }

    public Double getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(Double firstClass) {
        this.firstClass = firstClass;
    }

    public Double getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(Double secondClass) {
        this.secondClass = secondClass;
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
                Double.compare(that.businessClass, businessClass) == 0 &&
                Objects.equals(time, that.time) &&
                Objects.equals(firstClass, that.firstClass) &&
                Objects.equals(secondClass, that.secondClass);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rid, stationA, stationB, distance, time, businessClass, firstClass, secondClass);
    }
}
