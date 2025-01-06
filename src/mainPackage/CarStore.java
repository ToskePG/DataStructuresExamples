package mainPackage;

// Implementacija kružnog reda koristeći niz
public class CarStore {

    private Car[] queue; // Niz za čuvanje automobila
    private int front;   // Indeks prednjeg elementa u redu
    private int rear;    // Indeks zadnjeg elementa u redu
    private int size;    // Trenutni broj elemenata u redu
    private int capacity; // Maksimalni kapacitet reda
    private String storeName;

    public CarStore(String storeName, int capacity) {
        this.storeName = storeName;
        this.capacity = capacity;
        this.queue = new Car[capacity]; // Inicijalizuje niz sa datim kapacitetom
        this.front = 0; // Prednji element počinje na indeksu 0
        this.rear = -1; // Zadnji element počinje pre početka niza
        this.size = 0;  // Red je inicijalno prazan
    }

    // Proverava da li je red prazan
    // Ako je size == 0, red je prazan
    public boolean isEmpty() {
        return size == 0;
    }

    // Proverava da li je red pun
    // Ako je size == capacity, red je pun
    public boolean isFull() {
        return size == capacity;
    }

    // Dodaje novi auto na kraj reda
    // Ako je red pun, ispisuje poruku i ne dodaje element
    public boolean enqueue(Car car) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add car.");
            return false;
        }
        rear = (rear + 1) % capacity; // Povećava rear sa kružnim efektom
        queue[rear] = car; // Dodaje auto na poziciju rear
        size++; // Povećava veličinu reda
        return true;
    }

    // Uklanja auto sa početka reda
    // Ako je red prazan, ispisuje poruku i ne uklanja element
    public boolean dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot remove car.");
            return false;
        }
        queue[front] = null; // Uklanja auto sa pozicije front
        front = (front + 1) % capacity; // Povećava front sa kružnim efektom
        size--; // Smanjuje veličinu reda
        return true;
    }

    // Vraća auto sa početka reda bez uklanjanja
    public Car peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return queue[front]; // Vraća auto sa pozicije front
    }

    // Prikazuje sve automobile u redu
    // Prolazi kroz niz od front do rear
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int temp = front;
        for (int i = 0; i < size; i++) {
            System.out.println(queue[temp].toString());
            temp = (temp + 1) % capacity; // Kružni efekat
        }
    }

    // Računa prosečnu cenu svih automobila u redu
    public int averagePrice() {
        if (isEmpty()) {
            return 0; // Ako je red prazan, prosečna cena je 0
        }
        int sum = 0;
        int temp = front;
        for (int i = 0; i < size; i++) {
            sum += queue[temp].getCarPrice(); // Sabira cene automobila
            temp = (temp + 1) % capacity; // Kružni efekat
        }
        return sum / size; // Vraća prosečnu cenu
    }

    // Dodaje auto u red samo ako je njegova cena veća od prosečne cene
    public boolean addBiggerThanAvg(Car car) {
        if (car.getCarPrice() > this.averagePrice()) {
            return this.enqueue(car); // Dodaje auto koristeći funkciju enqueue
        }
        return false; // Ne dodaje auto ako cena nije veća od prosečne
    }
}
