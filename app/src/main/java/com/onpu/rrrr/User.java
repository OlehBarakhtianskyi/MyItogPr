package com.onpu.rrrr;

import java.util.Date;

public class User {
    int id;
    Date time;
    String search;

    public User(int id, Date time, String search) {
        this.id = id;
        this.time = time;
        this.search = search;
    }

    public User(int id, Date time) {
        this.id = id;
        this.time = time;
        this.search = "";
    }

    public User() {
        this.id = -1;
        this.time = time;
        this.search = "";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
