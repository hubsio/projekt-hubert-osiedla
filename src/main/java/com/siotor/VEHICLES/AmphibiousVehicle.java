package com.siotor.VEHICLES;

class AmphibiousVehicle extends Vehicle {
    private double waterSpeed;

    public AmphibiousVehicle(String name, double size, String engineType, double waterSpeed) {
        super(name, size, "AmphibiousVehicle", engineType, waterSpeed);
        this.waterSpeed = waterSpeed;
    }
}
