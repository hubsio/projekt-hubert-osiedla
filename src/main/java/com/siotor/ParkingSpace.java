package com.siotor;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace extends RentedSpace {
    private List<Object> storedItems;
    private static int nextId = 1;

    public ParkingSpace(double length, double width) {
        super(nextId++, length, width);
    }

    public void addItem(Object item) {
        storedItems.add(item);
    }

    public void removeItem(Object item) {
        storedItems.remove(item);
    }

    public List<Object> getStoredItems() {
        return storedItems;
    }

    public static int getNextId() {
        return nextId;
    }
}

