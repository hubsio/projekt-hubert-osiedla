package com.siotor;

class AmphibiousVehicle extends Vehicle {
    private String landType;

    public AmphibiousVehicle(String name, Dimensions dimensions, String landType) {
        super(name, dimensions);
        this.landType = landType;
    }

    public String getLandType() {
        return landType;
    }
}
