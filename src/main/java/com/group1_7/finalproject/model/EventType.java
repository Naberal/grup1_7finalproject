package com.group1_7.finalproject.model;

public enum EventType {
    Work(1), Study(0.75), Night_time(1.2);
    private double coefficient;

    EventType(double i) {
        coefficient = i;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
