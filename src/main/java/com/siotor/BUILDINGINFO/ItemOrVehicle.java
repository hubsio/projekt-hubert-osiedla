package com.siotor.BUILDINGINFO;

public class ItemOrVehicle implements Item {
    private String name;
    private double area;

    public ItemOrVehicle(String name, double area) {
        this.name = name;
        this.area = area;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return area;
    }
}