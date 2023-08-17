package com.siotor;

public class Dimensions {
    private double length;
    private double width;
    private double height;

    public Dimensions(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return length * width;
    }
    public double calculateVolume() {
        return length * width * height;
    }
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
