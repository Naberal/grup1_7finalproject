package com.group1_7.finalproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "event")
public class Event extends UUIdModel {
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "time")
    private LocalTime time;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EventType type;
    @ManyToMany
    @JoinTable(name = "event_participants", joinColumns = @JoinColumn(name = "event"),
            inverseJoinColumns = @JoinColumn(name = "workers"))
    private List<Worker> workers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", type=" + type +
                ", workers=" + workers +
                '}';
    }
}
