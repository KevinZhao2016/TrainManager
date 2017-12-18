package com.entity;

import java.util.Objects;

public class StationEntity {
    private int id;
    private String name;
    private String pinyin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationEntity that = (StationEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(pinyin, that.pinyin);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, pinyin);
    }
}
