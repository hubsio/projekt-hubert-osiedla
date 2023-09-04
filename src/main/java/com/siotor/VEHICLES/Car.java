package com.siotor.VEHICLES;

class Car extends Vehicle {
    private int numOfDoors;

    public Car(String name, double size, String engineType, int numOfDoors) {
        super(name, size, "Car", engineType, numOfDoors);
        this.numOfDoors = numOfDoors;
    }
}
