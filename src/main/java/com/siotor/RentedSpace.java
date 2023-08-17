package com.siotor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentedSpace {
    private int id;
    private Dimensions dimensions;
    private Date startDate;
    private Date endDate;
    private List<Dimensions> storedItems;



    public RentedSpace(int id, Dimensions dimensions) {
        this.id = id;
        this.dimensions = dimensions;
        this.storedItems = new ArrayList<>();
    }
    public boolean isOverdue() {
        Date currentDate = new Date();
        return endDate != null && currentDate.after(endDate);
    }

    public double calculateArea() {
        return dimensions.calculateArea();
    }
    public double calculateVolume() {
        return dimensions.calculateVolume();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }
    //////////// NEW
    public void addItem(Dimensions itemDimensions) throws TooManyThingsException {
        double totalVolumeOfStoredItems = storedItems.stream()
                .mapToDouble(Dimensions::calculateVolume)
                .sum();

        if (totalVolumeOfStoredItems + itemDimensions.calculateVolume() > dimensions.calculateVolume()) {
            throw new TooManyThingsException("Przedmiot jest za duży, aby go dodać!");
        }

        storedItems.add(itemDimensions);

        if (itemDimensions.calculateVolume() <= dimensions.calculateVolume() - totalVolumeOfStoredItems) {
            System.out.println("Przedmiot pasuje do pomieszczenia!");
        }
    }
}
