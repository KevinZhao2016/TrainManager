package com.model;

import java.sql.Timestamp;
import java.util.Objects;

public class TripsEntity {
    private int tid;
    private String tname;
    private String passby;
    private Timestamp departure;
    private Integer ttype;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPassby() {
        return passby;
    }

    public void setPassby(String passby) {
        this.passby = passby;
    }

    public Timestamp getDeparture() {
        return departure;
    }

    public void setDeparture(Timestamp departure) {
        this.departure = departure;
    }

    public Integer getTtype() {
        return ttype;
    }

    public void setTtype(Integer ttype) {
        this.ttype = ttype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripsEntity that = (TripsEntity) o;
        return tid == that.tid &&
                Objects.equals(tname, that.tname) &&
                Objects.equals(passby, that.passby) &&
                Objects.equals(departure, that.departure) &&
                Objects.equals(ttype, that.ttype);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tid, tname, passby, departure, ttype);
    }
}
