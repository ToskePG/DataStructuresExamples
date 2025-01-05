package mainPackage;

public class CarStore {

	private String storeName;
	private Node head;
	
	CarStore(String storeName){
		this.storeName = storeName;
		this.head = null;
	}
	
	// Provjerava da li je lista prazna. Lista je prazna ako je head = null. Nema provjere da li je lista puna, jer je lista dinamicka struktura koja nikad nije puna.
	public boolean isEmpty() {
		return this.head == null;
	}
	
	// Dodavanje na pocetak.
	public boolean addAtBeginning(Car c1) {
		Node newNode = new Node(c1);
		if(isEmpty()) {
			head = newNode;
			return true;
		}
		newNode.setNext(head); // Directly set the new node's next to current head
	    head = newNode;        // Update head to point to the new node
	    return true;
	}
	
	// Dodavanje na kraj (Ukoliko u testu nije napomenuto nista dodatno, dodavanje se podrazumijeva da bude na kraj liste!)
	public boolean addAtEnd(Car c1) {
		Node newNode = new Node(c1);
		if(isEmpty()) {
			head = newNode;
			return true;
		}
		Node temp = head;
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(newNode);
		return true;
	}
	
	// LIFO implementacija za ulancanu listu (Last in First out), brise se zadnji Node.
	public boolean deleteLastNode() {
		if(isEmpty()) {
			System.out.println("Lista je vec prazna.");
			return false;
		}
		if(head.getNext() == null) {
			head = null;
			return true;
		}
		Node temp = head;
		Node prev = null;
		while(temp.getNext() != null) {
			prev = temp;
			temp = temp.getNext();
		}
		prev.setNext(null);
		return true;
	}
	
	// FIFO implementacija ulancane liste (First in First out), brise se glava liste. Potrebno je postaviti novu glavu.
	public boolean deleteAtStart() {
		if(isEmpty()) {
			System.out.println("Lista je vec prazna. ");
			return false;
		}
		if(head.getNext() == null) {
			head = null;
			return true;
		}
		head = head.getNext();
		return true;
	}
	
	// Dodavanje ide isto kao gornje funkcije. Ako nije specijalno napomenuto, dodavanje vrsi na kraj.
	public boolean addBiggerThanAvg(Car c1) {
		if(c1.getCarPrice() > this.averagePrice()) {
			this.addAtEnd(c1);
			return true;
		}
		return false;
	}
	
	public int averagePrice() {
		int sum = 0;
		int counter = 0;
		if(isEmpty()) {
			return 0;
		}
		if(head.getNext() == null) {
			return head.getData().getCarPrice();
		}
		Node temp = head;
		while(temp != null) {
			counter++;
			sum = sum + temp.getData().getCarPrice();
			temp = temp.getNext();
		}
		return sum/counter;
	}
	
	public void displayList() {
		if(isEmpty()) {
			System.out.println("Lista je prazna. ");
			return;
		}
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.toString());
			temp = temp.getNext();
		}
		System.out.println();
	}
}
