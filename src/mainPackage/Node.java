package mainPackage;

public class Node {
	
	private Car car;
    private Node next;

    // Konstruktor za Node
    public Node(Car car) {
        this.car = car;
        this.next = null;
    }

    // Getter za car
    public Car getCar() {
        return this.car; // Koristimo this.car umesto car
    }

    // Setter za car
    public void setCar(Car car) {
        this.car = car;
    }

    // Getter za next
    public Node getNext() {
        return this.next; // Koristimo this.next umesto next
    }

    // Setter za next
    public void setNext(Node next) {
        this.next = next;
    }

    // Metoda za prikaz informacija o čvoru
    @Override
    public String toString() {
        return "Node: " + this.car.toString();
    }
}
