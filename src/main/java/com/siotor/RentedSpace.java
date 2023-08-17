package com.siotor;

import java.util.Date;

public class RentedSpace {
    private int id;
    private double length;
    private double width;
    private Date startDate;
    private Date endDate;

    public RentedSpace(int id, double length, double width) {
        this.id = id;
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
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
