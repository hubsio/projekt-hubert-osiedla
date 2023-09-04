package com.siotor.BUILDINGINFO;

import com.siotor.EXCEPTIONS.ProblematicTenantException;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tenant {
    private Person person;
    private List<Apartment> rentedApartments = new ArrayList<>();
    private List<ParkingSpace> rentedParkingSpaces = new ArrayList<>();
    private List<File> debts = new ArrayList<>();

    public Tenant(Person person) {
        this.person = person;
    }

    public void addDebt(File debt) {
        debts.add(debt);
    }

    private String getRentedItemsList() {
        List<String> rentedItems = new ArrayList<>();
        for (Apartment apartment : rentedApartments) {
            rentedItems.add("Mieszkanie #" + apartment.getId());
        }
        for (ParkingSpace parkingSpace : rentedParkingSpaces) {
            rentedItems.add("Miejsce parkingowe #" + parkingSpace.getId());
        }
        return String.join(", ", rentedItems);
    }

    public Person getPerson() {
        return person;
    }

    public List<Apartment> getRentedApartments() {
        return rentedApartments;
    }

    public List<ParkingSpace> getRentedParkingSpaces() {
        return rentedParkingSpaces;
    }

}

//    public void rentApartment(Apartment apartment) throws ProblematicTenantException {
//        if (debts.size() >= 3) {
//            throw new ProblematicTenantException("Osoba " + person.getFirstName() + " " + person.getLastName() +
//                    " posiadała już najem pomieszczeń: " + getRentedItemsList());
//        }
//
//        if (rentedApartments.size() < 5) {
//            rentedApartments.add(apartment);
//            apartment.addOccupant(person);
//        }
//    }
//
//
//    public void rentParkingSpace(ParkingSpace parkingSpace) throws ProblematicTenantException {
//        if (debts.size() >= 3) {
//            throw new ProblematicTenantException("Osoba " + person.getFirstName() + " " + person.getLastName() +
//                    " posiadała już najem pomieszczeń: " + getRentedItemsList());
//        }
//
//        if (rentedParkingSpaces.size() < 5) {
//            rentedParkingSpaces.add(parkingSpace);
//        }
//    }
//
//    public void unrentApartment(Apartment apartment) {
//        rentedApartments.remove(apartment);
//        apartment.removeOccupant(person);
//    }
//
//
//    public void unrentParkingSpace(ParkingSpace parkingSpace) {
//        rentedParkingSpaces.remove(parkingSpace);
//    }

