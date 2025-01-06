package mainPackage;

public class CarStore {
	
	  private Node top; // Pokazuje na vrh steka
    private String storeName;

    public CarStore(String storeName) {
        this.storeName = storeName;
        this.top = null; // Stek je inicijalno prazan
    }

    // Proverava da li je stek prazan
    // Ako je top == null, stek je prazan
    public boolean isEmpty() {
        return top == null;
    }

    // Dodaje novi auto na vrh steka (LIFO)
    // Novi čvor postaje vrh steka i pokazuje na prethodni vrh
    public boolean push(Car car) {
        Node newNode = new Node(car);
        newNode.setNext(top); // Novi čvor pokazuje na trenutni vrh
        top = newNode; // Ažurira se top da pokazuje na novi čvor
        return true;
    }

    // Skida auto sa vrha steka (LIFO)
    // Top se ažurira tako da pokazuje na sledeći čvor
    public boolean pop() {
        if (isEmpty()) {
            System.out.println("Stek je već prazan.");
            return false;
        }
        top = top.getNext(); // Pomera top na sledeći čvor
        return true;
    }

    // Vraća podatke o autu na vrhu steka bez uklanjanja
    // Ako je stek prazan, vraća null
    public Car peek() {
        if (isEmpty()) {
            System.out.println("Stek je prazan.");
            return null;
        }
        return top.getData();
    }

    // Prikazuje sve automobile u steku
    // Kreće od vrha steka i prolazi kroz sve čvorove
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Stek je prazan.");
            return;
        }
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }

    // Računa prosečnu cenu svih automobila u steku
    // Prolazi kroz sve čvorove, sabira cene i deli sa brojem automobila
    public int averagePrice() {
        if (isEmpty()) {
            return 0; // Ako je stek prazan, prosečna cena je 0
        }
        int sum = 0, count = 0;
        Node temp = top;
        while (temp != null) {
            sum += temp.getData().getCarPrice(); // Sabira cene automobila
            count++; // Broji automobile
            temp = temp.getNext();
        }
        return sum / count; // Vraća prosečnu cenu
    }

    // Dodaje auto na stek samo ako je njegova cena veća od prosečne cene
    public boolean addBiggerThanAvg(Car car) {
        if (car.getCarPrice() > this.averagePrice()) {
            return this.push(car); // Dodaje auto koristeći funkciju push
        }
        return false; // Ne dodaje auto ako cena nije veća od prosečne
    }
}
