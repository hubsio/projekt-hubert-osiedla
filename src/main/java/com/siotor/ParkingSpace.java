package com.siotor;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace extends RentedSpace {
    private List<Object> storedItems;
    private Dimensions dimensions;

    public ParkingSpace(int id, Dimensions dimensions) {
        super(id, dimensions);
        storedItems = new ArrayList<>();
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

}


