package com.siotor.BUILDINGINFO;

import com.siotor.EXCEPTIONS.ProblematicTenantException;
import com.siotor.VEHICLES.Vehicle;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Person {
    private String firstName;
    private String lastName;
    private File evictionNotice;
    private String pesel;
    private String address;
    private Date dateOfBirth;
    private List<Apartment> rentedApartments = new ArrayList<>();
    private List<ParkingSpace> rentedParkingSpaces = new ArrayList<>();


    public Person(String firstName, String lastName, String pesel, String address, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public void receiveEvictionNotice(File evictionNotice) {
        this.evictionNotice = evictionNotice;
    }

    public File getEvictionNotice() {
        return evictionNotice;
    }

    public String getPesel() {
        return pesel;
    }

    public String getAddress() {
        return address;
    }

    public void rentSpace(Apartment apartment) {
        rentedApartments.add(apartment);
        apartment.setTenant(this);
//        System.out.println("Mieszkanie zostało wynajęte przez: " + getFirstName());
    }

    public void rentSpace(ParkingSpace parkingSpace) {
        rentedParkingSpaces.add(parkingSpace);
        parkingSpace.setTenant(this);
//        System.out.println("Miejsce parkingowe zostało wynajęte przez: " + getFirstName());
    }

    public void rentApartmentWithLimit(Apartment apartment) throws ProblematicTenantException {
        if (rentedApartments.size() + rentedParkingSpaces.size() >= 3) {
            throw new ProblematicTenantException("Osoba " + getFirstName() + " " + getLastName() +
                    " posiadała już najem 3 pomieszczeń");
        }

        if (rentedApartments.size() < 5) {
            rentedApartments.add(apartment);
            apartment.addOccupant(this);
        }
    }

    public void rentParkingSpaceWithLimit(ParkingSpace parkingSpace) throws ProblematicTenantException {
        if (rentedApartments.size() + rentedParkingSpaces.size() >= 3) {
            throw new ProblematicTenantException("Osoba " + getFirstName() + " " + getLastName() +
                    " posiadała już najem 3 pomieszczeń");
        }

        if (rentedParkingSpaces.size() < 5) {
            rentedParkingSpaces.add(parkingSpace);
        }
    }

    public void unrentApartment(Apartment apartment) {
        rentedApartments.remove(apartment);
        apartment.removeOccupant(this);
    }

    public void unrentParkingSpace(ParkingSpace parkingSpace) {
        rentedParkingSpaces.remove(parkingSpace);
    }

    public void displayRentedProperties() {
        System.out.println("Wynajęte nieruchomości:");

        int counter = 1;
        for (Apartment apartment : rentedApartments) {
            System.out.println(counter + ". Mieszkanie #" + apartment.getId());
            counter++;
        }

        for (ParkingSpace parkingSpace : rentedParkingSpaces) {
            System.out.println(counter + ". Miejsce parkingowe #" + parkingSpace.getId());
            counter++;
        }
    }

    //public void rentSpace(Apartment apartment) throws ProblematicTenantException {
//    if (rentedApartments.size() + rentedParkingSpaces.size() >= 3) {
//        throw new ProblematicTenantException("Osoba " + getFirstName() + " " + getLastName() +
//                " posiadała już najem 3 pomieszczeń");
//    }
//
//    rentedApartments.add(apartment);
//    apartment.setTenant(this);
//    System.out.println("Mieszkanie zostało wynajęte przez: " + getFirstName());
//}
//
//    public void rentSpace(ParkingSpace parkingSpace) throws ProblematicTenantException {
//        if (rentedApartments.size() + rentedParkingSpaces.size() >= 3) {
//            throw new ProblematicTenantException("Osoba " + getFirstName() + " " + getLastName() +
//                    " posiadała już najem 3 pomieszczeń");
//        }
//
//        rentedParkingSpaces.add(parkingSpace);
//        parkingSpace.setTenant(this);
//        System.out.println("Miejsce parkingowe zostało wynajęte przez: " + getFirstName());
//    }
    public List<Apartment> getRentedApartments() {
        return rentedApartments;
    }

    public List<ParkingSpace> getRentedParkingSpaces() {
        return rentedParkingSpaces;
    }

//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }
//}
//
//
//    public Person(String firstName, String lastName, String pesel, String address) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.pesel = pesel;
//        this.address = address;
//        this.rentedSpaces = new ArrayList<>();
//    }
//
//
//    public boolean hasProblematicOverdue() {
//        long overdueCount = rentedSpaces.stream()
//                .filter(RentedSpace::isOverdue)
//                .count();
//
//        return overdueCount >= 3;
//    }
//
//    public void checkAndGenerateOverdueNotice() throws ProblematicTenantException {
//        if (hasProblematicOverdue()) {
//            throw new ProblematicTenantException("Osoba " + getFirstName() + " " + getLastName() +
//                    " posiadała już najem pomieszczeń: " + getRentedSpacesList());
//        }
//    }
//
//    private String getRentedSpacesList() {
//        return rentedSpaces.stream()
//                .map(RentedSpace::getId)
//                .map(Object::toString)
//                .collect(Collectors.joining(", "));
//    }
//
//
//    public void printOverdueNotice() {
//        if (overdueNotice != null) {
//            System.out.println("Pismo za spóźnione wypowiedzenie: " + firstName + " " + lastName);
//            System.out.println("Wypowiedzenie zapisane jako: " + overdueNotice.getName());
//        } else {
//            System.out.println("Brak spóźnionego wypowiedzenia: " + firstName + " " + lastName);
//        }
//    }
//
//    public boolean rentSpace(RentedSpace rentedSpace) {
//        if (rentedSpaces.size() < 5) {
//            rentedSpaces.add(rentedSpace);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public String toString() {
//        String rentedSpacesInfo = rentedSpaces.stream()
//                .map(person -> "  - NUMER MIESZKANIA: " + person.getId())
//                .collect(Collectors.joining("\n"));
//
//        return "Imię: " + firstName +
//                "\nNazwisko: " + lastName +
//                "\nPESEL: " + pesel +
//                "\nAdres: " + address +
//                "\nWynajęte pomieszczenia:\n" + rentedSpacesInfo;
//    }
//
//    public void showPersonDetails() {
//        System.out.println("Imię: " + firstName);
//        System.out.println("Nazwisko: " + lastName);
//        System.out.println("PESEL: " + pesel);
//        System.out.println("Adres: " + address);
//        System.out.println("Mieszkanie/Miejsce Parkingowe ID: " + getRentedSpacesList());
//    }
//    public void setApartment(Apartment apartment) {
//        this.apartment = apartment;
//    }
//
//    public void setParkingSpace(ParkingSpace parkingSpace) {
//        this.parkingSpace = parkingSpace;
//    }
//
//
//
//
//    public String getPesel() {
//        return pesel;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public List<RentedSpace> getRentedSpaces() {
//        return rentedSpaces;
//    }
//
//    public boolean canRentMoreSpaces() {
//        return rentedSpaces.size() < 5;
//    }
//
//    public void addItem(Item item) {
//        addedItems.add(item);
//    }
//
//    public void addVehicle(Vehicle vehicle) {
//        addedVehicles.add(vehicle);
//    }

}





