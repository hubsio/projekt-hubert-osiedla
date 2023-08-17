package com.siotor;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private int id;
    private List<Apartment> apartments;
    private List<ParkingSpace> parkingSpaces;

    public Block(int id) {
        this.id = id;
        apartments = new ArrayList<>();
        parkingSpaces = new ArrayList<>();
    }

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public void addParkingSpace(ParkingSpace parkingSpace) {
        parkingSpaces.add(parkingSpace);
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public List<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }

    public int getId() {
        return id;
    }
}

