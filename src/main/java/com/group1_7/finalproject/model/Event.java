package com.group1_7.finalproject.model;

import javax.persistence.*;
import java.sql.*;

@Entity
@Table(name = "event")
public class Event extends UUIdModel {
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private Date date;
    @Column(name = "time")
    private Time time;
    @ManyToMany
    @JoinColumn(table = "event_type", referencedColumnName = "name")//todo
    private long type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }


    public java.sql.Time getTime() {
        return time;
    }

    public void setTime(java.sql.Time time) {
        this.time = time;
    }


    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", type=" + type +
                '}';
    }
}
