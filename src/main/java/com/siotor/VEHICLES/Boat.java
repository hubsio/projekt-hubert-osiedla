package com.siotor.VEHICLES;

class Boat extends Vehicle {
    private double waterDisplacement;

    public Boat(String name, double size, String engineType, double waterDisplacement) {
        super(name, size, "Boat", engineType, waterDisplacement);
        this.waterDisplacement = waterDisplacement;
    }
}
