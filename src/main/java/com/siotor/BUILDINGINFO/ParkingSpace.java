package com.siotor.BUILDINGINFO;

import com.siotor.EXCEPTIONS.TooManyThingsException;
import com.siotor.VEHICLES.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace extends Room {
    //    private List<Person> occupants;
    private List<Item> storedItems = new ArrayList<>();
    private static int idCounter = 0;
    private int id;
    private double area;
    private Person tenant;
    private List<Item> items;
    private List<Vehicle> vehicles;


    public ParkingSpace(double area) {
        super(area);
        this.area = area;
        this.id = idCounter++;
        items = new ArrayList<>();
        vehicles = new ArrayList<>();
    }

    public void storeItem(Item item) throws TooManyThingsException {
        double totalAreaOccupied = storedItems.stream()
                .mapToDouble(Item::getArea)
                .sum();
        if (totalAreaOccupied + item.getArea() > getArea()) {
            throw new TooManyThingsException("Wyrzuć stare przedmioty aby dodać nowe");
        }
        storedItems.add(item);
    }

    public List<Item> getStoredItems() {
        return storedItems;
    }

    public void setTenant(Person tenant) {
        this.tenant = tenant;
    }

    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public Person getTenant() {
        return tenant;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    @Override
    public String toString() {
        return "ParkingSpace #" + id + " (Area: " + area + ")";
    }

    public boolean isOccupied() {
        return tenant != null;
    }
//    public static void main(String[] args) {
//        // Creating people
//        Person person1 = new Person("John", "Doe", "123456789", "Icy Street 1", new Date(1900 - 1900, 1, 12));
//        Person person2 = new Person("Alice", "Smith", "987654321", "Sunny Street 42", new Date(1985 - 1900, 5, 20));
//
//        // Creating apartments and parking spaces
//        Apartment apartment1 = new Apartment(50.0, person1);
//        Apartment apartment2 = new Apartment(70.0, person2);
//        ParkingSpace parkingSpace1 = new ParkingSpace(15.0);
//        ParkingSpace parkingSpace2 = new ParkingSpace(20.0);
//
//        // Creating tenants
//        Tenant tenant1 = new Tenant(person1);
//        Tenant tenant2 = new Tenant(person2);
//
//        // Trying to rent apartments and parking spaces
//        try {
//            tenant1.rentApartment(apartment1);
//            tenant1.rentParkingSpace(parkingSpace1);
//
//            tenant2.rentApartment(apartment2);
//            tenant2.rentParkingSpace(parkingSpace2);
//        } catch (ProblematicTenantException e) {
//            System.out.println("Exception during renting: " + e.getMessage());
//        }
//
//        // Trying to store items in a parking space
//        try {
//            parkingSpace1.storeItem(new ItemWithSize("Small Item", 0.5));
//            parkingSpace1.storeItem(new ItemWithSize("Medium Item", 1.0));
//            parkingSpace1.storeItem(new ItemWithSize("Large Item", 2.0));
//            parkingSpace1.storeItem(new ItemWithSize("Oversized Item", 50.0));  // Exception here
//        } catch (TooManyThingsException e) {
//            System.out.println("Exception during storing item: " + e.getMessage());
//        }
//
//        // Displaying results
//        System.out.println("Apartments rented by Tenant 1: " + tenant1.getRentedApartments());
//        System.out.println("Parking spaces rented by Tenant 1: " + tenant1.getRentedParkingSpaces());
//        System.out.println("Apartments rented by Tenant 2: " + tenant2.getRentedApartments());
//        System.out.println("Parking spaces rented by Tenant 2: " + tenant2.getRentedParkingSpaces());
//
//        System.out.println("Items in Parking Space 1: " + parkingSpace1.getStoredItems());
//        System.out.println("Items in Parking Space 2: " + parkingSpace2.getStoredItems());
//    }
}

//////
//    public void showSpaceDetails() {
//        System.out.println("Miejsce parkingowe ID: " + getId() +
//                ", Metraż: " + calculateArea() + " m2" +
//                ", Data rozpoczęcia wynajmu: " + startDate +
//                ", Data zakończenia wynajmu: " + endDate);
//    }
//
//    public boolean isRented(List<Person> people) {
//        return people.stream()
//                .anyMatch(person -> person.getRentedSpaces().contains(this));
//    }
//
//    @Override
//    public String toString() {
//        return "Miejsce parkingowe o ID: " + getId() + ", Metraż: " + dimensions.calculateArea() + " m^2";
//    }
//
//    public List<Person> getOccupants() {
//        return occupants;
//    }
//
//    @Override
//    public boolean showContents() {
//        boolean hasContents = false;
//
//        if (!vehicles.isEmpty()) {
//            System.out.println("Pojazdy:");
//            vehicles.forEach(vehicle -> System.out.println("- " + vehicle.getName()));
//            hasContents = true;
//        }
//        return hasContents;
//    }
//
//    public Dimensions getDimensions() {
//        return dimensions;
//    }
//
//    public void addVehicle(Vehicle vehicle) {
//        vehicles.add(vehicle);
//    }
//
//    public List<Vehicle> getStoredVehicles() {
//        return vehicles;
//    }
//}
//

