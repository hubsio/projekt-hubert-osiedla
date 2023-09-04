package com.siotor.BUILDINGINFO;

import java.util.ArrayList;
import java.util.List;

public class Room implements Item{

    protected int id;

    protected double area;

    public Room(double area) {
        this.area = area;
    }
    @Override
    public String getName() {
        return "Pokój #" + id;
    }

    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }
}

