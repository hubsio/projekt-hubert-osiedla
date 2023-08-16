package com.siotor;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {
    private int parkingNumber;
    private double parkingSize;
    private List<Object> storedItems;

    public ParkingSpace(int parkingNumber, double parkingAreaSize) {
        this.parkingNumber = parkingNumber;
        this.parkingSize = parkingAreaSize;
        this.storedItems = new ArrayList<>();
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public double getParkingAreaSize() {
        return parkingSize;
    }

    public void storeItem(Object item) {
        storedItems.add(item);
    }

    public void removeItem(Object item) {
        storedItems.remove(item);
    }

    public void parkVehicle(Vehicle vehicle) {
        storedItems.add(vehicle);
    }

    public void unparkVehicle(Vehicle vehicle) {
        storedItems.remove(vehicle);
    }


}
