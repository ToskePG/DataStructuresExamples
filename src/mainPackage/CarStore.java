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
	public boolean addAtBegging(Car c1) {
		Node newNode = new Node(c1);
		if(isEmpty()) {
			head = newNode;
			return true;
		}
		Node temp = head;
		head = newNode;
		head.setNext(temp);
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
	
	public void displayList() {
		if(isEmpty()) {
			System.out.println("Lista je prazna. ");
			return;
		}
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.toString());
			temp = temp.getNext();
		}
	}
}
