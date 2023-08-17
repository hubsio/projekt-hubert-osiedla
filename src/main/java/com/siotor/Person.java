package com.siotor;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String firstName;
    private String lastName;
    private String pesel;
    private String address;
    private Date birthDate;
    private List<RentedSpace> rentedSpaces;

    public Person(String firstName, String lastName, String pesel, String address, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.address = address;
        this.birthDate = birthDate;
        this.rentedSpaces = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public String getAddress() {
        return address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<RentedSpace> getRentedSpaces() {
        return rentedSpaces;
    }

    public boolean canRentMoreSpaces() {
        return rentedSpaces.size() < 5;
    }

    public boolean rentSpace(RentedSpace rentedSpace) {
        if (rentedSpaces.size() < 5) {
            rentedSpaces.add(rentedSpace);
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}



