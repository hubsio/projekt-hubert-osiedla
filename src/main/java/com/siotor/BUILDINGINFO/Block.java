package com.siotor.BUILDINGINFO;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private String blockName;
    private List<Apartment> apartments = new ArrayList<>();
    private List<ParkingSpace> parkingSpaces;


    public Block(String blockName) {
        this.blockName = blockName;
        this.apartments = new ArrayList<>();
        this.parkingSpaces = new ArrayList<>();

    }
    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }
    public List<Apartment> getApartments() {
        return apartments;
    }
    public List<Apartment> getAvailableApartments() {
        List<Apartment> availableApartments = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (!apartment.isOccupied()) {
                availableApartments.add(apartment);
            }
        }
        return availableApartments;
    }

    public List<ParkingSpace> getAvailableParkingSpaces() {
        List<ParkingSpace> availableParkingSpaces = new ArrayList<>();
        for (ParkingSpace parkingSpace : parkingSpaces) {
            if (!parkingSpace.isOccupied()) {
                availableParkingSpaces.add(parkingSpace);
            }
        }
        return availableParkingSpaces;
    }


    ////

    public String getBlockName() {
        return blockName;
    }

    public List<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }

    public void addParkingSpace(ParkingSpace parkingSpace) {
        parkingSpaces.add(parkingSpace);
    }


}
















//package com.siotor.BUILDINGINFO;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Block {
//    private int id;
//    private List<Apartment> apartments;
//    private List<ParkingSpace> parkingSpaces;
//    private List<Person> people;
//
//    public Block(int id) {
//        this.id = id;
//        apartments = new ArrayList<>();
//        parkingSpaces = new ArrayList<>();
//    }
//
//    public void addApartment(Apartment apartment) {
//        apartments.add(apartment);
//    }
//
//    public void addParkingSpace(ParkingSpace parkingSpace) {
//        parkingSpaces.add(parkingSpace);
//    }
//
//    public List<Apartment> getApartments() {
//        return apartments;
//    }
//
//    public List<ParkingSpace> getParkingSpaces() {
//        return parkingSpaces;
//    }
//
//    public int getId() {
//        return id;
//    }
//}

