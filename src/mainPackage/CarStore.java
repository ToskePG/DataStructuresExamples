package mainPackage;

public class CarStore {

	 private String storeName;
	    private Node head;  // Glava liste
	    private Node tail;  // Rep liste

	    // Konstruktor za CarStore
	    public CarStore(String storeName) {
	        this.storeName = storeName;
	        this.head = null;
	        this.tail = null;
	    }

	    // Getter i setter za storeName
	    public String getStoreName() {
	        return storeName;
	    }

	    public void setStoreName(String storeName) {
	        this.storeName = storeName;
	    }

	    // Metoda za dodavanje automobila u listu
	    public void addCar(Car car) {
	        Node newNode = new Node(car);
	        if (head == null) {
	            // Ako je lista prazna, postavljamo novi čvor kao glavu i rep
	            head = newNode;
	            tail = newNode;
	            tail.setNext(head);  // Kružna veza
	        } else {
	            // Ako lista nije prazna, dodajemo novi čvor na kraj i ažuriramo rep
	            tail.setNext(newNode);
	            tail = newNode;
	            tail.setNext(head);  // Kružna veza
	        }
	    }

	    // Metoda za dodavanje automobila samo ako je cena veća od prosečne
	    public void addCarIfPriceAboveAverage(Car car) {
	        double avgPrice = calculateAveragePrice();
	        if (car.getCarPrice() > avgPrice) {
	            addCar(car);
	            System.out.println("Automobil " + car.getCarBrand() + " je dodat jer je cena veća od prosečne.");
	        } else {
	            System.out.println("Automobil " + car.getCarBrand() + " nije dodat jer je cena manja ili jednaka prosečnoj.");
	        }
	    }

	    // Metoda za računanje prosečne cene automobila u listi
	    public double calculateAveragePrice() {
	        if (head == null) {
	            return 0.0;
	        }

	        double totalPrice = 0.0;
	        int count = 0;
	        Node temp = head;

	        do {
	            totalPrice += temp.getCar().getCarPrice();
	            count++;
	            temp = temp.getNext();
	        } while (temp != head);

	        return totalPrice / count;
	    }

	    // Metoda za brisanje automobila iz liste po brendu
	    public void deleteCarByBrand(String carBrand) {
	        if (head == null) {
	            System.out.println("Lista je prazna.");
	            return;
	        }

	        Node temp = head;
	        Node prev = null;

	        // Prolazimo kroz listu dok ne nađemo automobil sa traženim brendom
	        do {
	            if (temp.getCar().getCarBrand().equals(carBrand)) {
	                if (temp == head && temp == tail) {
	                    // Ako je lista imala samo jedan element
	                    head = null;
	                    tail = null;
	                } else if (temp == head) {
	                    // Ako je element na početku liste
	                    head = head.getNext();
	                    tail.setNext(head);
	                } else if (temp == tail) {
	                    // Ako je element na kraju liste
	                    tail = prev;
	                    tail.setNext(head);
	                } else {
	                    // Ako je element u sredini liste
	                    prev.setNext(temp.getNext());
	                }
	                System.out.println("Automobil brenda " + carBrand + " je obrisan.");
	                return;
	            }
	            prev = temp;
	            temp = temp.getNext();
	        } while (temp != head);

	        System.out.println("Automobil brenda " + carBrand + " nije pronađen.");
	    }

	    // Metoda za prikaz svih automobila u listi
	    public void displayCars() {
	        if (head == null) {
	            System.out.println("Lista je prazna.");
	            return;
	        }

	        Node temp = head;
	        System.out.println("Automobili u prodavnici " + storeName + ":");
	        do {
	            System.out.println(temp);
	            temp = temp.getNext();
	        } while (temp != head);
	    }

	    // Metoda za pronalaženje automobila po brendu
	    public void findCarByBrand(String carBrand) {
	        if (head == null) {
	            System.out.println("Lista je prazna.");
	            return;
	        }

	        Node temp = head;
	        boolean found = false;
	        do {
	            if (temp.getCar().getCarBrand().equals(carBrand)) {
	                System.out.println("Pronađen automobil: " + temp.getCar());
	                found = true;
	            }
	            temp = temp.getNext();
	        } while (temp != head);

	        if (!found) {
	            System.out.println("Automobil brenda " + carBrand + " nije pronađen.");
	        }
	    }

	    // Metoda za brisanje svih automobila iz liste
	    public void clearStore() {
	        head = null;
	        tail = null;
	        System.out.println("Svi automobili su obrisani iz prodavnice.");
	    }

	    // Metoda za proveru da li je lista prazna
	    public boolean isEmpty() {
	        return head == null;
	    }

	    // Metoda za dobijanje broja automobila u listi
	    public int getNumberOfCars() {
	        if (head == null) {
	            return 0;
	        }

	        int count = 0;
	        Node temp = head;
	        do {
	            count++;
	            temp = temp.getNext();
	        } while (temp != head);

	        return count;
	    }

	    // Metoda za prikaz informacija o prodavnici
	    public void printStoreInfo() {
	        System.out.println("Naziv prodavnice: " + storeName);
	        System.out.println("Broj automobila u prodavnici: " + getNumberOfCars());
	        System.out.println("Prosečna cena automobila: " + calculateAveragePrice());
	        displayCars();
	    }
}
