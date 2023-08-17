package com.siotor;

class CityCar extends Vehicle {
    private int passengersCapacity;

    public CityCar(String name, Dimensions dimensions, int passengersCapacity) {
        super(name, dimensions);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }
}
