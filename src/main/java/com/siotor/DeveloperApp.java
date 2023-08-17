package com.siotor;

import java.util.Date;

public class DeveloperApp {
    public static void main(String[] args) {
        Person person1 = new Person("John", "Doe", "12345678901", "123 Main St", new Date(1990, 1, 1));

        Apartment apartment1 = new Apartment(6.5, 8.2);
        ParkingSpace parkingSpace1 = new ParkingSpace(2.5, 5.0);

        Block block1 = new Block(1);
        block1.addApartment(apartment1);
        block1.addParkingSpace(parkingSpace1);

        HousingEstate housingEstate = new HousingEstate();
        housingEstate.addBlock(block1);

        Date startDate = new Date();
        Date endDate = new Date();

        startDate.setYear(2023);
        startDate.setMonth(7);
        startDate.setDate(17);

        endDate.setYear(2023);
        endDate.setMonth(8);
        endDate.setDate(31);

        setLeaseDates(apartment1, startDate, endDate);
        setLeaseDates(parkingSpace1, startDate, endDate);

        if (person1.rentSpace(apartment1) && person1.rentSpace(parkingSpace1)) {
            System.out.println("John has rented Apartment with area " + apartment1.calculateArea() +
                    " m² from " + apartment1.getStartDate() + " to " + apartment1.getEndDate() +
                    " and Parking Space with area " + parkingSpace1.calculateArea() +
                    " m² from " + parkingSpace1.getStartDate() + " to " + parkingSpace1.getEndDate());
        } else {
            System.out.println("John cannot rent more spaces.");
        }


    }

    private static void setLeaseDates(RentedSpace rentedSpace, Date startDate, Date endDate) {
        rentedSpace.setStartDate(startDate);
        rentedSpace.setEndDate(endDate);
    }
}