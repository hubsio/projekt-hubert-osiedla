package com.siotor;

import java.util.Optional;

public class Apartment {
    private int flatNumber;
    private double flatSize;
    private Person resident;
    private ParkingSpace rentedParkingSpace;

    public Apartment(int flatNumber, double flatAreaSize) {
        this.flatNumber = flatNumber;
        this.flatSize = flatAreaSize;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public double getFlatSize() {
        return flatSize;
    }

    public Person getResident() {
        return resident;
    }

    public Optional<ParkingSpace> getRentedParkingSpace() {
        return Optional.ofNullable(rentedParkingSpace);
    }
    public boolean isOccupied() {
        return resident != null;
    }
    public void checkInResident(Person person) {
        if (!isOccupied()) {
            this.resident = resident;
        }
    }
    public void checkOutResident() {
        this.resident = null;
    }

}
