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
    private File overdueNotice;

    public Person(String firstName, String lastName, String pesel, String address, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.address = address;
        this.birthDate = birthDate;
        this.rentedSpaces = new ArrayList<>();
    }
    public boolean hasProblematicOverdue() {
        long overdueCount = rentedSpaces.stream()
                .filter(RentedSpace::isOverdue)
                .count();

        return overdueCount >= 3;
    }

    public void checkAndGenerateOverdueNotice() throws ProblematicTenantException {
        if (hasProblematicOverdue()) {
            throw new ProblematicTenantException("Osoba " + getFirstName() + " " + getLastName() +
                    " posiadała już najem pomieszczeń: " + getRentedSpacesList());
        }
    }

    private String getRentedSpacesList() {
        return rentedSpaces.stream()
                .map(RentedSpace::getId)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }


    public void printOverdueNotice() {
        if (overdueNotice != null) {
            System.out.println("Pismo za spóźnione wypowiedzenie: " + firstName + " " + lastName);
            System.out.println("Wypowiedzenie zapisane jako: " + overdueNotice.getName());
        } else {
            System.out.println("Brak spóźnionego wypowiedzenia: " + firstName + " " + lastName);
        }
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



