package com.siotor;

import com.siotor.BUILDINGINFO.*;
import com.siotor.EXCEPTIONS.ProblematicTenantException;
import com.siotor.EXCEPTIONS.TooManyThingsException;
import com.siotor.VEHICLES.Vehicle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Wynik {
    public static void main(String[] args) {

        HousingEstate estate = new HousingEstate();

        Block block1 = new Block("Promyczek");
        estate.addBlock(block1);

        List<Person> people = new ArrayList<>();
        people.add(new Person("Marcin", "Wójcik", "321654987", "Grunwaldzka 20", new Date(1987, 7, 15)));
        people.add(new Person("Ewa", "Kaczmarek", "789654123", "Piękna 8", new Date(1993, 4, 25)));
        people.add(new Person("Tomasz", "Zając", "456123789", "Wesoła 30", new Date(1991, 9, 5)));
        people.add(new Person("Magdalena", "Górska", "987321654", "Krótka 5", new Date(1989, 2, 18)));
        people.add(new Person("Kamil", "Nowicki", "123789456", "Szkolna 18", new Date(1997, 12, 8)));

        List<Apartment> apartments = new ArrayList<>();
        apartments.add(new Apartment(50.0));
        apartments.add(new Apartment(60.0));
        apartments.add(new Apartment(70.0));
        apartments.add(new Apartment(80.0));
        apartments.add(new Apartment(90.0));
        apartments.add(new Apartment(100.0));
        apartments.add(new Apartment(200.0));

        List<ParkingSpace> parkingSpaces = new ArrayList<>();
        parkingSpaces.add(new ParkingSpace(15.0));
        parkingSpaces.add(new ParkingSpace(20.0));
        parkingSpaces.add(new ParkingSpace(25.0));
        parkingSpaces.add(new ParkingSpace(30.0));
        parkingSpaces.add(new ParkingSpace(35.0));
        parkingSpaces.add(new ParkingSpace(40.0));
        parkingSpaces.add(new ParkingSpace(45.0));

        people.get(0).rentSpace(apartments.get(0));
        people.get(1).rentSpace(apartments.get(1));
        people.get(2).rentSpace(apartments.get(2));
        people.get(3).rentSpace(apartments.get(3));
        people.get(4).rentSpace(apartments.get(4));

        people.get(0).rentSpace(parkingSpaces.get(0));
        people.get(1).rentSpace(parkingSpaces.get(1));
        people.get(2).rentSpace(parkingSpaces.get(2));
        people.get(3).rentSpace(parkingSpaces.get(3));
        people.get(4).rentSpace(parkingSpaces.get(4));

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Witaj w systemie Deweloperskim!\n");
            displayPeople(people);
            System.out.println("Wybierz osobę:");

            int personChoice = scanner.nextInt();
            if (personChoice >= 1 && personChoice <= people.size()) {
                Person selectedPerson = people.get(personChoice - 1);
                showMainMenu(selectedPerson, estate, scanner, apartments, parkingSpaces);
            } else if (personChoice == 0) {
                System.out.println("Do widzenia!");
                scanner.close();
                return;
            } else {
                System.out.println("Niepoprawny numer. Proszę podaj numer jeszcze raz");
            }
        }

    }

    private static void displayPeople(List<Person> people) {
        for (int i = 0; i < people.size(); i++) {
            System.out.println((i + 1) + ". " + people.get(i).getFirstName() + " " + people.get(i).getLastName());
        }
        System.out.println("0. Wyjdź z programu.");
    }


    private static void showMainMenu(Person person, HousingEstate estate, Scanner scanner, List<Apartment> apartments, List<ParkingSpace> parkingSpaces) {
        while (true) {
            System.out.println("\nMenu Główne dla " + person.getFirstName() + " " + person.getLastName() + ":");
            System.out.println("0. Wyjście");
            System.out.println("1. Wyświetl dane osobowe");
            System.out.println("2. Wyświetl dostępne pomieszczenia");
            System.out.println("3. Wynajmij nowe pomieszczenie");
            System.out.println("4. Oddaj nowe pomieszczenie");
            System.out.println("5. Zamelduj lub wymelduj");
            System.out.println("6. Wyświetl zawartość miejsc parkingowych");
            System.out.println("7. Przechowaj przedmioty/pojazdy na parkingu");
            System.out.println("8. Usuń przedmioty/pojazdy z parkingu");
            System.out.println("9. Zapisz stan osiedla do pliku");
            System.out.print("Wybierz opcję: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Wychodze z menu ...");
                    return;
                case 1:
                    displayPersonalInformationWithProperties(person, estate);
                    break;
                case 2:
                    displayAvailableProperties(apartments, parkingSpaces);
                    break;
                case 3:
                    rentProperty(person, apartments, parkingSpaces, scanner);
                    break;
                case 4:
                    returnProperty(person, apartments, parkingSpaces, scanner);
                    break;
                case 5:
                    manageRentedProperties(person, scanner);
                    break;
                case 6:
                    displayItemsOnParkingSpaces(parkingSpaces);
                    break;
                case 7:
                    storeItemsOrVehiclesOnParkingSpace(person, parkingSpaces, scanner);
                    break;
                case 8:
                    removeItemsOrVehiclesFromParkingSpace(person, parkingSpaces, scanner);
                    break;
                case 9:
                    System.out.print("Podaj nazwę pliku do zapisu: ");
                    String filename = scanner.next();
                    saveStateToFile(apartments, parkingSpaces, filename);
                    break;
                default:
                    System.out.println("Niepoprawny wybór. Proszę podać poprawną opcję.");
                    break;
            }
        }
    }

    private static void displayPersonalInformationWithProperties(Person person, HousingEstate estate) {
        System.out.println("Personal Information:");
        System.out.println("Name: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("PESEL: " + person.getPesel());
        System.out.println("Address: " + person.getAddress());
        System.out.println("Posiadane mieszkania: " + person.getRentedApartments());
        System.out.println("Posiadane miejsca parkingowe: " + person.getRentedParkingSpaces());
    }

    private static void displayAvailableProperties(List<Apartment> apartments, List<ParkingSpace> parkingSpaces) {
        System.out.println();

        int propertyCounter = 1;

        System.out.println("Apartamenty:");
        for (Apartment apartment : apartments) {
            if (apartment.getTenant() == null) {
                System.out.println(propertyCounter + ". Apartment #" + propertyCounter + " - Powierzchnia: " + apartment.getArea() + " m²");
            }
            propertyCounter++;
        }

        System.out.println("\nMiejsca Parkingowe:");
        for (ParkingSpace parkingSpace : parkingSpaces) {
            if (parkingSpace.getTenant() == null) {
                System.out.println(propertyCounter + ". Parking Space #" + propertyCounter + " - Powierzchnia: " + parkingSpace.getArea() + " m²");
            }
            propertyCounter++;
        }
    }
    private static void rentProperty(Person person, List<Apartment> apartments, List<ParkingSpace> parkingSpaces, Scanner scanner) {
        System.out.println("\nDostępne pomieszczenia do wynajęcia:");
        displayAvailableProperties(apartments, parkingSpaces);

        System.out.print("Wybierz numer pomieszczenia do wynajęcia: ");
        int propertyChoice = scanner.nextInt();

        if (propertyChoice >= 1 && propertyChoice <= apartments.size()) {
            Apartment selectedApartment = apartments.get(propertyChoice - 1);
            if (selectedApartment.getTenant() == null) {
                try {
                    person.rentApartmentWithLimit(selectedApartment);
                    apartments.remove(selectedApartment);
                    System.out.println("Wynajęto apartament #" + propertyChoice);
                } catch (ProblematicTenantException e) {
                    System.out.println("Błąd: " + e.getMessage());
                }
            } else {
                System.out.println("Ten apartament jest już wynajęty.");
            }
        } else if (propertyChoice > apartments.size() && propertyChoice <= apartments.size() + parkingSpaces.size()) {
            ParkingSpace selectedParkingSpace = parkingSpaces.get(propertyChoice - 1 - apartments.size());
            if (selectedParkingSpace.getTenant() == null) {
                try {
                    person.rentParkingSpaceWithLimit(selectedParkingSpace);
                    parkingSpaces.remove(selectedParkingSpace);
                    System.out.println("Wynajęto miejsce parkingowe #" + propertyChoice);
                } catch (ProblematicTenantException e) {
                    System.out.println("Błąd: " + e.getMessage());
                }
            } else {
                System.out.println("To miejsce parkingowe jest już wynajęte.");
            }
        } else {
            System.out.println("Niepoprawny numer pomieszczenia.");
        }
    }
    private static void returnProperty(Person person, List<Apartment> apartments, List<ParkingSpace> parkingSpaces, Scanner scanner) {
        System.out.println("\nTwoje wynajęte pomieszczenia:");
        person.displayRentedProperties();

        System.out.print("Wybierz numer pomieszczenia do oddania: ");
        int propertyChoice = scanner.nextInt();

        if (propertyChoice >= 1 && propertyChoice <= person.getRentedApartments().size()) {
            Apartment rentedApartment = person.getRentedApartments().get(propertyChoice - 1);
            person.unrentApartment(rentedApartment);
            apartments.add(rentedApartment);
            System.out.println("Oddano wynajęty apartament #" + rentedApartment.getId());
        } else if (propertyChoice > person.getRentedApartments().size() && propertyChoice <= person.getRentedApartments().size() + person.getRentedParkingSpaces().size()) {
            ParkingSpace rentedParkingSpace = person.getRentedParkingSpaces().get(propertyChoice - 1 - person.getRentedApartments().size());
            person.unrentParkingSpace(rentedParkingSpace);
            parkingSpaces.add(rentedParkingSpace);
            System.out.println("Oddano wynajęte miejsce parkingowe #" + rentedParkingSpace.getId());
        } else {
            System.out.println("Niepoprawny numer pomieszczenia.");
        }
    }
    private static void manageRentedProperties(Person person, Scanner scanner) {
        System.out.println("\nZarządzanie wynajętymi pomieszczeniami:");
        System.out.println("1. Zamelduj osobę do mieszkania");
        System.out.println("2. Wymelduj osobę z mieszkania");
        System.out.println("0. Powrót do menu głównego");
        System.out.print("Wybierz opcję: ");

        int manageChoice = scanner.nextInt();
        switch (manageChoice) {
            case 1:
                checkInToApartment(person, scanner);
                break;
            case 2:
                checkOutOfApartment(person, scanner);
                break;
            case 0:
                System.out.println("Powrót do menu głównego.");
                break;
            default:
                System.out.println("Niepoprawny wybór. Proszę podać poprawną opcję.");
                break;
        }
    }

    private static void checkInToApartment(Person person, Scanner scanner) {
        List<Apartment> rentedApartments = person.getRentedApartments();

        System.out.println("\nTwoje wynajęte mieszkania:");
        for (int i = 0; i < rentedApartments.size(); i++) {
            Apartment apartment = rentedApartments.get(i);
            if (apartment.getTenant() != null) {
                System.out.println((i + 1) + ". Apartament #" + apartment.getId() + " - Powierzchnia: " + apartment.getArea() + " m² - Zameldowany mieszkaniec: " + apartment.getTenant().getFirstName() + " " + apartment.getTenant().getLastName());
            } else {
                System.out.println((i + 1) + ". Apartament #" + apartment.getId() + " - Powierzchnia: " + apartment.getArea() + " m²");
            }
        }

        System.out.print("Podaj numer mieszkania, do którego chcesz się zameldować: ");
        int apartmentNumber = scanner.nextInt();
        if (apartmentNumber >= 1 && apartmentNumber <= rentedApartments.size()) {
            Apartment selectedApartment = rentedApartments.get(apartmentNumber - 1);
            if (selectedApartment.getTenant() == null) {
                System.out.println("Osoba jeszcze nie jest zameldowana do mieszkania #" + selectedApartment.getId());
                System.out.print("Czy chcesz się teraz zameldować do tego mieszkania? (T/N): ");
                String confirmation = scanner.next();
                if (confirmation.equalsIgnoreCase("T")) {
                    selectedApartment.setTenant(person);
                    System.out.println("Osoba została zameldowana do mieszkania #" + selectedApartment.getId());
                } else {
                    System.out.println("Anulowano zameldowanie.");
                }
            } else {
                System.out.println("Ten apartament jest już zameldowany przez: " + selectedApartment.getTenant().getFirstName() + " " + selectedApartment.getTenant().getLastName());
            }
        } else {
            System.out.println("Niepoprawny numer mieszkania.");
        }
    }

    private static void checkOutOfApartment(Person person, Scanner scanner) {
        List<Apartment> rentedApartments = person.getRentedApartments();

        System.out.println("\nTwoje wynajęte mieszkania:");
        for (int i = 0; i < rentedApartments.size(); i++) {
            Apartment apartment = rentedApartments.get(i);
            if (apartment.getTenant() != null) {
                System.out.println((i + 1) + ". Apartament #" + apartment.getId() + " - Powierzchnia: " + apartment.getArea() + " m² - Zameldowany mieszkaniec: " + apartment.getTenant().getFirstName() + " " + apartment.getTenant().getLastName());
            }
        }

        System.out.print("Podaj numer mieszkania, z którego chcesz się wymeldować: ");
        int apartmentNumber = scanner.nextInt();
        if (apartmentNumber >= 1 && apartmentNumber <= rentedApartments.size()) {
            Apartment selectedApartment = rentedApartments.get(apartmentNumber - 1);
            if (selectedApartment.getTenant() != null) {
                selectedApartment.setTenant(null);
                System.out.println("Osoba została wymeldowana z mieszkania #" + selectedApartment.getId());
            } else {
                System.out.println("To mieszkanie jest już wolne.");
            }
        } else {
            System.out.println("Niepoprawny numer mieszkania.");
        }
    }
    private static void displayItemsOnParkingSpaces(List<ParkingSpace> parkingSpaces) {
        System.out.println("\nPrzedmioty i pojazdy na miejscach parkingowych:");

        boolean foundItems = false;

        for (ParkingSpace parkingSpace : parkingSpaces) {
            System.out.println("\nMiejsce parkingowe #" + parkingSpace.getId() + " (Powierzchnia: " + parkingSpace.getArea() + " m²):");

            List<Item> items = parkingSpace.getStoredItems();
            if (!items.isEmpty()) {
                for (Item item : items) {
                    System.out.println("- Przedmiot/Pojazd: " + item.getName());
                    foundItems = true;
                }
            } else {
                System.out.println("Brak przedmiotów.");
            }
        }

        if (!foundItems) {
            System.out.println("Brak przedmiotów na żadnym miejscu parkingowym.");
        }
    }
    private static void storeItemsOrVehiclesOnParkingSpace(Person person, List<ParkingSpace> parkingSpaces, Scanner scanner) {
        System.out.println("\nPrzechowywanie przedmiotów/pojazdów na Twoim miejscu parkingowym:");

        List<ParkingSpace> ownedParkingSpaces = parkingSpaces.stream()
                .filter(parkingSpace -> parkingSpace.getTenant() != null && parkingSpace.getTenant().equals(person))
                .collect(Collectors.toList());

        if (ownedParkingSpaces.isEmpty()) {
            System.out.println("Nie posiadasz żadnego miejsca parkingowego.");
            return;
        }

        System.out.println("Twoje miejsca parkingowe:");
        int counter = 1;
        for (ParkingSpace parkingSpace : ownedParkingSpaces) {
            System.out.println(counter + ". Miejsce parkingowe #" + parkingSpace.getId() + " - Powierzchnia: " + parkingSpace.getArea() + " m²");
            counter++;
        }

        System.out.print("Wybierz numer miejsca parkingowego: ");
        int parkingSpaceChoice = scanner.nextInt();

        if (parkingSpaceChoice >= 1 && parkingSpaceChoice <= ownedParkingSpaces.size()) {
            ParkingSpace selectedParkingSpace = ownedParkingSpaces.get(parkingSpaceChoice - 1);

            System.out.print("Podaj nazwę przedmiotu/pojazdu: ");
            String itemName = scanner.next();

            System.out.print("Podaj wymiar przedmiotu/pojazdu (powierzchnia): ");
            double itemArea = scanner.nextDouble();

            try {
                ItemOrVehicle newItem = new ItemOrVehicle(itemName, itemArea);
                selectedParkingSpace.storeItem(newItem);

                System.out.println(newItem.getName() + " dodany do miejsca parkingowego #" + selectedParkingSpace.getId());
            } catch (TooManyThingsException e) {
                System.out.println("Błąd: " + e.getMessage());
            }
        } else {
            System.out.println("Niepoprawny numer miejsca parkingowego.");
        }
    }
    private static void removeItemsOrVehiclesFromParkingSpace(Person person, List<ParkingSpace> parkingSpaces, Scanner scanner) {
        System.out.println("\nUsuwanie przedmiotów/pojazdów z Twojego miejsca parkingowego:");

        List<ParkingSpace> ownedParkingSpaces = parkingSpaces.stream()
                .filter(parkingSpace -> parkingSpace.getTenant() != null && parkingSpace.getTenant().equals(person))
                .collect(Collectors.toList());

        if (ownedParkingSpaces.isEmpty()) {
            System.out.println("Nie posiadasz żadnego miejsca parkingowego.");
            return;
        }

        System.out.println("Twoje miejsca parkingowe:");
        int counter = 1;
        for (ParkingSpace parkingSpace : ownedParkingSpaces) {
            System.out.println(counter + ". Miejsce parkingowe #" + parkingSpace.getId() + " - Powierzchnia: " + parkingSpace.getArea() + " m²");
            counter++;
        }

        System.out.print("Wybierz numer miejsca parkingowego: ");
        int parkingSpaceChoice = scanner.nextInt();

        if (parkingSpaceChoice >= 1 && parkingSpaceChoice <= ownedParkingSpaces.size()) {
            ParkingSpace selectedParkingSpace = ownedParkingSpaces.get(parkingSpaceChoice - 1);

            List<Item> items = selectedParkingSpace.getStoredItems();
            List<Vehicle> vehicles = selectedParkingSpace.getVehicles();

            if (!items.isEmpty() || !vehicles.isEmpty()) {
                System.out.println("Zawartość miejsca parkingowego #" + selectedParkingSpace.getId() + ":");

                int itemCounter = 1;
                for (Item item : items) {
                    System.out.println(itemCounter + ". Przedmiot: " + item.getName());
                    itemCounter++;
                }

                for (Vehicle vehicle : vehicles) {
                    System.out.println(itemCounter + ". Pojazd: " + vehicle.getName());
                    itemCounter++;
                }

                System.out.print("Wybierz numer przedmiotu/pojazdu do usunięcia: ");
                int itemChoice = scanner.nextInt();

                if (itemChoice >= 1 && itemChoice <= itemCounter) {
                    if (itemChoice <= items.size()) {
                        Item removedItem = items.remove(itemChoice - 1);
                        System.out.println("Usunięto przedmiot: " + removedItem.getName() + " z miejsca parkingowego #" + selectedParkingSpace.getId());
                    } else {
                        Vehicle removedVehicle = vehicles.remove(itemChoice - 1 - items.size());
                        System.out.println("Usunięto pojazd: " + removedVehicle.getName() + " z miejsca parkingowego #" + selectedParkingSpace.getId());
                    }
                } else {
                    System.out.println("Niepoprawny numer przedmiotu/pojazdu.");
                }
            } else {
                System.out.println("Twoje miejsce parkingowe jest puste.");
            }
        } else {
            System.out.println("Niepoprawny numer miejsca parkingowego.");
        }
    }
    private static void saveStateToFile(List<Apartment> apartments, List<ParkingSpace> parkingSpaces, String filename) { //moze nie dzialac *in progress*
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(apartments);
            outputStream.writeObject(parkingSpaces);
            System.out.println("Zapisano stan osiedla do pliku " + filename);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania stanu osiedla: " + e.getMessage());
        }
    }
}





