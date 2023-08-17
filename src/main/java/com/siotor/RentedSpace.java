package com.siotor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentedSpace {
    private int id;
    private Dimensions dimensions;
    private Date startDate;
    private Date endDate;



    public RentedSpace(int id, Dimensions dimensions) {
        this.id = id;
        this.dimensions = dimensions;
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
}
