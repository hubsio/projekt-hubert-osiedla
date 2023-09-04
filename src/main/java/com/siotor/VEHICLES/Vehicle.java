package com.siotor.VEHICLES;

import com.siotor.BUILDINGINFO.Item;


public class Vehicle implements Item { // TODO klasa abstrakycjna, pomyslec gdzie jeszcze jej uzyc
    private String name;
    private double area;
    private String type;
    private String engineType;
    private double specificAttribute;

    public Vehicle(String name, double area, String type, String engineType, double specificAttribute) {
        this.name = name;
        this.area = area;
        this.type = type;
        this.engineType = engineType;
        this.specificAttribute = specificAttribute;
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




