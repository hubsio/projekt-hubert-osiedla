package com.siotor;


import java.util.ArrayList;
import java.util.List;

public class Apartment extends RentedSpace {

    private List<Person> occupants;
    private static int nextId = 1;

    public Apartment(double length, double width) {
        super(nextId++, length, width);
    }

    public void addOccupant(Person person) {
        occupants.add(person);
    }

    public void removeOccupant(Person person) {
        occupants.remove(person);
    }

    public List<Person> getOccupants() {
        return occupants;
    }
}