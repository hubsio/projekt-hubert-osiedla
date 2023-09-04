package com.siotor.VEHICLES;

class Motorcycle extends Vehicle {
    private boolean isSportBike;

    public Motorcycle(String name, double size, String engineType, boolean isSportBike) {
        super(name, size, "Motorcycle", engineType, isSportBike ? 1 : 0);
        this.isSportBike = isSportBike;
    }
}
