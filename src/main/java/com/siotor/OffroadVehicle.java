package com.siotor;

public class OffroadVehicle extends Vehicle{
    private String engineType;
    public OffroadVehicle(String name, Dimensions dimensions, String engineType) {
        super(name, dimensions);
        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }
}
