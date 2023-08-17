package com.siotor;

class Motorcycle extends Vehicle {
    private boolean isElectric;

    public Motorcycle(String name, Dimensions dimensions, boolean isElectric) {
        super(name, dimensions);
        this.isElectric = isElectric;
    }

    public boolean isElectric() {
        return isElectric;
    }
}
