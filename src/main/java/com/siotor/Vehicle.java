package com.siotor;

public class Vehicle {
    private String type;
    private String licensePlate;

    public Vehicle(String type, String licensePlate) {
        this.type = type;
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
