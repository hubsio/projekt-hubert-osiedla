package com.siotor;


import java.util.ArrayList;
import java.util.List;

public class Apartment extends RentedSpace {

    private List<Person> occupants;
    private static int nextId = 1;

    public Apartment(Dimensions dimensions) {
        super(nextId++, dimensions);
        occupants = new ArrayList<>();
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