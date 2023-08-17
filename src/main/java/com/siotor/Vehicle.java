package com.siotor;

public class Vehicle {
    private String name;
    private Dimensions dimensions;

    public Vehicle(String name, Dimensions dimensions) {
        this.name = name;
        this.dimensions = dimensions;
    }

    public String getName() {
        return name;
    }
    public double calculateArea() {
        return dimensions.calculateArea();
    }
    public double calculateVolume() {
        return dimensions.calculateVolume();
    }
}



