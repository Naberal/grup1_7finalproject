package com.group1_7.finalproject.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(targetEntity = Worker.class)
    @JoinColumn(name = "workers_id", referencedColumnName = "id")
    private UUID workerId;
    @Column(name = "date")
    private Date date;
    @Column(name = "time")
    private LocalTime time;
    @Column(name = "salary")
    private BigDecimal salary;


    public Salary() {
    }

    public int getId() {
        return id;
    }

    public UUID getWorkerId() {
        return workerId;
    }

    public void setWorkerId(UUID workerId) {
        this.workerId = workerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return ", date=" + date +
                ", time=" + time +
                ", salary=" + salary;
    }
}
