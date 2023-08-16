package com.siotor;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private String identifier;
    private boolean responsibleForRent;
    private List<Apartment> rentedApartments;
    private List<ParkingSpace> rentedParkingSpace;

    public Person(String firstName, String lastName, String identifier, boolean responsibleForRent, List<Apartment> rentedApartments, List<ParkingSpace> rentedParkingSpace) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identifier = identifier;
        this.responsibleForRent = responsibleForRent;
        this.rentedApartments = new ArrayList<>();
        this.rentedParkingSpace = new ArrayList<>();
    }
    public boolean canRentMoreProperties() {
        return (rentedApartments.size() + rentedParkingSpace.size()) < 5;
    }
    public void rentApartment(Apartment apartment) {
        if (canRentMoreProperties()) {
            rentedApartments.add(apartment);
        }
    }
    public void rentParkingSpace(ParkingSpace parkingSpace) {
        if (canRentMoreProperties()) {
            rentedParkingSpace.add(parkingSpace);
        }
    }
}
