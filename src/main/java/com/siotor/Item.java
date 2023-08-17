package com.siotor;

public class Item {
    private String name;
    private Dimensions dimensions;

    public Item(String name, Dimensions dimensions) {
        this.name = name;
        this.dimensions = dimensions;
    }

    public String getName() {
        return name;
    }
    public double calculateArea() {
        return dimensions.calculateArea();
    }
}
