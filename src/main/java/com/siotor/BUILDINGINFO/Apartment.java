package com.siotor.BUILDINGINFO;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Apartment extends Room {

    private static int idCounter = 0;
    private int id;
    private double area;
    private Person owner;
    private Person tenant;
    private Date leaseStartDate;
    private Date leaseEndDate;
    private List<Person> occupants = new ArrayList<>();
    private ParkingSpace parkingSpace;


    public Apartment(double area) {
        super(area);
        this.id = idCounter++;
        this.area = area;
        this.owner = null;
        occupants.add(owner);
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setLeaseDates(Date startDate, Date endDate) {
        this.leaseStartDate = startDate;
        this.leaseEndDate = endDate;
    }

    public void setTenant(Person tenant) {
        this.tenant = tenant;
    }

    public boolean isLeaseExpired() {
        Date currentDate = new Date();
        return leaseEndDate != null && leaseEndDate.before(currentDate);
    }

    public void processEviction() {
        if (isLeaseExpired()) {
            File evictionNotice = new File("eviction_notice.txt");
            owner.receiveEvictionNotice(evictionNotice);
        }
    }

    public boolean isOccupied() {
        return tenant != null;
    }

    public int getId() {
        System.out.println("Hubi");
        return id;
    }

    public double getArea() {
        return area;
    }

    public void addOccupant(Person person) {
        occupants.add(person);
    }

    public void removeOccupant(Person person) {
        occupants.remove(person);
    }

    public Person getOwner() {
        return owner;
    }

    public Person getTenant() {
        return tenant;
    }

    public List<Person> getOccupants() {
        return occupants;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    @Override
    public String toString() {
        return "Apartment #" + id + " (Powierzchnia: " + area + ")";
    }

}
