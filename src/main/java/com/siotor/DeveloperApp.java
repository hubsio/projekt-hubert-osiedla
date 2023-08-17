//package com.siotor;
//
//import java.util.Date;
//
//public class DeveloperApp {
//
//    public static void main(String[] args) {
//        // Tworzenie przykładowej osoby
//        Person person = new Person("Alice", "Johnson", "123456789", "789 Maple St", new Date());
//
//        // Tworzenie przykładowych przestrzeni najmu (ParkingSpace)
//        ParkingSpace space1 = new ParkingSpace(1, 10.0, 2, 10);
//        ParkingSpace space2 = new ParkingSpace(2, 7.0, 8, 32);
//        ParkingSpace space3 = new ParkingSpace(3, 8.0, 32, 12);
//
//        // Ustawienie daty zakończenia najmu na przeszłość dla wszystkich przestrzeni (ParkingSpace)
//        space1.setEndDate(new Date(System.currentTimeMillis() - 86400000)); // 24 godziny temu
//        space2.setEndDate(new Date(System.currentTimeMillis() - 172800000)); // 48 godzin temu
//        space3.setEndDate(new Date(System.currentTimeMillis() - 259200000)); // 72 godziny temu
//
//        // Dodawanie przestrzeni najmu do osoby
//        person.getRentedSpaces().add(space1);
//        person.getRentedSpaces().add(space2);
//        person.getRentedSpaces().add(space3);
//
//        // Wywołanie metody sprawdzającej i generującej pismo
//        try {
//            person.checkAndGenerateOverdueNotice();
//        } catch (ProblematicTenantException e) {
//            System.out.println(e.getMessage());
//        }
//
//        // Tworzenie różnych typów pojazdów i wyświetlanie ich cech charakterystycznych
//        OffroadVehicle offroadVehicle = new OffroadVehicle("Offroad Beast", 5.0, 3.0, 2.0, "Gasoline");
//        System.out.println("Offroad Vehicle Engine Type: " + offroadVehicle.getEngineType());
//
//        CityCar cityCar = new CityCar("Urban Cruiser", 4.0, 2.0, 1.5, 4);
//        System.out.println("City Car Passengers Capacity: " + cityCar.getPassengersCapacity());
//
//        Boat boat = new Boat("SpeedyBoat", 10, 4, 10, "Motorboat");
//        System.out.println("Boat Type: " + boat.getBoatType());
//
//        Motorcycle motorcycle = new Motorcycle("ElectricBike", 2.0, 1.0, 1.0, true);
//        System.out.println("Motorcycle is Electric: " + motorcycle.isElectric());
//
//        AmphibiousVehicle amphibiousVehicle = new AmphibiousVehicle("AmphiCar", 6.0, 2.5, 2.5, "Land and Water");
//        System.out.println("Amphibious Vehicle Land Type: " + amphibiousVehicle.getLandType());
//
//        // Wywołanie metody wyświetlającej informacje o pismie
//        person.printOverdueNotice();
//    }
//}
//
//
////    public static void main(String[] args) {
////        // Tworzenie przykładowej osoby
////        Person person = new Person("Alice", "Johnson", "123456789", "789 Maple St", new Date());
////
////        // Tworzenie przykładowych przestrzeni najmu
////        RentedSpace space1 = new RentedSpace(1, 10.0, 5.0);
////        RentedSpace space2 = new RentedSpace(2, 7.0, 7.0);
////        RentedSpace space3 = new RentedSpace(3, 8.0, 6.0);
////
////        // Ustawienie daty zakończenia najmu na przeszłość dla wszystkich przestrzeni
////        space1.setEndDate(new Date(System.currentTimeMillis() - 86400000)); // 24 godziny temu
////        space2.setEndDate(new Date(System.currentTimeMillis() - 172800000)); // 48 godzin temu
////        space3.setEndDate(new Date(System.currentTimeMillis() - 259200000)); // 72 godziny temu
////
////        // Dodawanie przestrzeni najmu do osoby
////        person.getRentedSpaces().add(space1);
////        person.getRentedSpaces().add(space2);
////        person.getRentedSpaces().add(space3);
////
////        // Wywołanie metody sprawdzającej i generującej pismo
////        try {
////            person.checkAndGenerateOverdueNotice();
////        } catch (ProblematicTenantException e) {
////            System.out.println(e.getMessage());
////        }
////
////        // Wywołanie metody wyświetlającej informacje o pismie
////        person.printOverdueNotice();
////    }
////}
//
////    public static void main(String[] args) {
////        // Tworzenie przykładowej osoby
////        Person person = new Person("Jane", "Smith", "987654321", "456 Elm St", new Date());
////
////        // Tworzenie przykładowych wynajmowanych przestrzeni
////        RentedSpace space1 = new RentedSpace(1, 8.0, 6.0);
////        RentedSpace space2 = new RentedSpace(2, 9.0, 4.0);
////
////        // Ustawienie daty zakończenia najmu w przyszłości (brak zaległości)
////        space1.setEndDate(new Date(System.currentTimeMillis() + 604800000)); // Za tydzień
////        space2.setEndDate(new Date(System.currentTimeMillis() + 1209600000)); // Za 2 tygodnie
////
////        // Dodawanie wynajmowanych przestrzeni do osoby
////        person.getRentedSpaces().add(space1);
////        person.getRentedSpaces().add(space2);
////
////        // Wywołanie metody sprawdzającej i generującej pismo
////        person.checkAndGenerateOverdueNotice();
////
////        // Wyświetlenie informacji o pismach
////        person.printOverdueNotice();
////    }
////}
////////////////////////////////////////////
////        // Tworzenie przykładowej osoby
////        Person person = new Person("John", "Doe", "123456789", "123 Main St", new Date());
////
////        // Tworzenie przykładowych wynajmowanych przestrzeni
////        RentedSpace space1 = new RentedSpace(1, 10.0, 5.0);
////        RentedSpace space2 = new RentedSpace(2, 7.0, 7.0);
////
////        // Ustawienie daty zakończenia najmu na przeszłą dla space1 (by wygenerować pismo)
////        space1.setEndDate(new Date(System.currentTimeMillis())); // 24 godziny temu
////
////        // Dodawanie wynajmowanych przestrzeni do osoby
////        person.getRentedSpaces().add(space1);
////        person.getRentedSpaces().add(space2);
////
////        // Wywołanie metody sprawdzającej i generującej pismo
////        person.checkAndGenerateOverdueNotice();
////
////        // Wyświetlenie informacji o pismach
////        person.printOverdueNotice();
////    }
////}
////    public static void main(String[] args) {
////        Person person1 = new Person("John", "Doe", "12345678901", "123 Main St", new Date(1990, 1, 1));
////
////        Apartment apartment1 = new Apartment(6.5, 8.2);
////        ParkingSpace parkingSpace1 = new ParkingSpace(2.5, 5.0);
////
////        Block block1 = new Block(1);
////        block1.addApartment(apartment1);
////        block1.addParkingSpace(parkingSpace1);
////
////        HousingEstate housingEstate = new HousingEstate();
////        housingEstate.addBlock(block1);
////
////        Date startDate = new Date();
////        Date endDate = new Date();
////
////        startDate.setYear(2023);
////        startDate.setMonth(7);
////        startDate.setDate(17);
////
////        endDate.setYear(2023);
////        endDate.setMonth(8);
////        endDate.setDate(31);
////
////        setLeaseDates(apartment1, startDate, endDate);
////        setLeaseDates(parkingSpace1, startDate, endDate);
////
////        if (person1.rentSpace(apartment1) && person1.rentSpace(parkingSpace1)) {
////            System.out.println("John has rented Apartment with area " + apartment1.calculateArea() +
////                    " m² from " + apartment1.getStartDate() + " to " + apartment1.getEndDate() +
////                    " and Parking Space with area " + parkingSpace1.calculateArea() +
////                    " m² from " + parkingSpace1.getStartDate() + " to " + parkingSpace1.getEndDate());
////        } else {
////            System.out.println("John cannot rent more spaces.");
////        }
////
////
////    }
////
////    private static void setLeaseDates(RentedSpace rentedSpace, Date startDate, Date endDate) {
////        rentedSpace.setStartDate(startDate);
////        rentedSpace.setEndDate(endDate);
////    }
////}