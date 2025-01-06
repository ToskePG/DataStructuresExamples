package mainPackage;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite naziv prodavnice: ");
        String storeName = scanner.nextLine();
        CarStore store = new CarStore(storeName);

        int choice = -1; // Inicijalna vrednost za izbor opcije
        while (choice != 0) {
            // Prikaz menija
            System.out.println("\n--- Meni ---");
            System.out.println("1. Dodaj automobil");
            System.out.println("2. Dodaj automobil samo ako je cena veća od prosečne");
            System.out.println("3. Obriši automobil po brendu");
            System.out.println("4. Prikaži sve automobile");
            System.out.println("5. Pronađi automobil po brendu");
            System.out.println("6. Obriši sve automobile");
            System.out.println("7. Prikaži informacije o prodavnici");
            System.out.println("8. Izračunaj prosečnu cenu automobila");
            System.out.println("0. Izlaz");
            System.out.print("Izaberite opciju: ");

            // Provera validnosti unosa
            while (!scanner.hasNextInt()) {
                System.out.println("Nevažeći unos. Molimo unesite broj.");
                scanner.next(); // Očisti nevažeći unos
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Očisti bafer

            // Obrada izbora korisnika
            if (choice == 1) {
                // Dodaj automobil
                System.out.print("Unesite brend automobila: ");
                String brand = scanner.nextLine();
                System.out.print("Unesite cenu automobila: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Nevažeći unos. Molimo unesite broj za cenu.");
                    scanner.next(); // Očisti nevažeći unos
                }
                int price = scanner.nextInt();
                scanner.nextLine(); // Očisti bafer
                System.out.print("Unesite boju automobila: ");
                String color = scanner.nextLine();
                System.out.print("Unesite godinu proizvodnje: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Nevažeći unos. Molimo unesite broj za godinu proizvodnje.");
                    scanner.next(); // Očisti nevažeći unos
                }
                int year = scanner.nextInt();
                scanner.nextLine(); // Očisti bafer

                Car newCar = new Car(brand, price, color, year);
                store.addCar(newCar);
                System.out.println("Automobil " + brand + " je dodat u prodavnicu.");
            } else if (choice == 2) {
                // Dodaj automobil samo ako je cena veća od prosečne
                System.out.print("Unesite brend automobila: ");
                String brandAboveAvg = scanner.nextLine();
                System.out.print("Unesite cenu automobila: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Nevažeći unos. Molimo unesite broj za cenu.");
                    scanner.next(); // Očisti nevažeći unos
                }
                int priceAboveAvg = scanner.nextInt();
                scanner.nextLine(); // Očisti bafer
                System.out.print("Unesite boju automobila: ");
                String colorAboveAvg = scanner.nextLine();
                System.out.print("Unesite godinu proizvodnje: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Nevažeći unos. Molimo unesite broj za godinu proizvodnje.");
                    scanner.next(); // Očisti nevažeći unos
                }
                int yearAboveAvg = scanner.nextInt();
                scanner.nextLine(); // Očisti bafer

                Car carAboveAvg = new Car(brandAboveAvg, priceAboveAvg, colorAboveAvg, yearAboveAvg);
                store.addCarIfPriceAboveAverage(carAboveAvg);
            } else if (choice == 3) {
                // Obriši automobil po brendu
                System.out.print("Unesite brend automobila za brisanje: ");
                String brandToDelete = scanner.nextLine();
                store.deleteCarByBrand(brandToDelete);
            } else if (choice == 4) {
                // Prikaži sve automobile
                store.displayCars();
            } else if (choice == 5) {
                // Pronađi automobil po brendu
                System.out.print("Unesite brend automobila za pretragu: ");
                String brandToFind = scanner.nextLine();
                store.findCarByBrand(brandToFind);
            } else if (choice == 6) {
                // Obriši sve automobile
                store.clearStore();
                System.out.println("Svi automobili su obrisani iz prodavnice.");
            } else if (choice == 7) {
                // Prikaži informacije o prodavnici
                store.printStoreInfo();
            } else if (choice == 8) {
                // Izračunaj prosečnu cenu automobila
                double avgPrice = store.calculateAveragePrice();
                System.out.println("Prosečna cena automobila u prodavnici: " + avgPrice);
            } else if (choice == 0) {
                // Izlaz
                System.out.println("Hvala što ste koristili naš program. Doviđenja!");
            } else {
                // Nevažeća opcija
                System.out.println("Nevažeća opcija. Molimo pokušajte ponovo.");
            }
        }

        scanner.close();
    }
}