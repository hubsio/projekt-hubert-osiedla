package com.siotor;

class Boat extends Vehicle {
    private String boatType;

    public Boat(String name, Dimensions dimensions, String boatType) {
        super(name, dimensions);
        this.boatType = boatType;
    }

    public String getBoatType() {
        return boatType;
    }
}
