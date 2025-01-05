package mainPackage;

public class Test {

	public static void main(String[] args) {
		
		Car c1 = new Car("Golf 1", 7500, "Metalik", 2014);
		Car c2 = new Car("Golf 2", 3500, "Metalik", 2007);
		Car c3 = new Car("Golf 3", 4500, "Metalik", 2008);
		Car c4 = new Car("Golf 4", 5500, "Metalik", 2009);		
		CarStore store = new CarStore("Voli Motors");
		
		store.displayList();
		store.deleteLastNode();
		System.out.println("------------------------------");
		
		store.addAtBegging(c2);
		store.displayList();
		System.out.println("------------------------------");
		
		store.addAtBegging(c1);
		store.displayList();
		System.out.println("------------------------------");
		
		store.addAtEnd(c3);
		store.displayList();
		System.out.println("------------------------------");
		
		store.addAtEnd(c4);
		store.displayList();
		System.out.println("------------------------------");
		
		
		
		
	}

}
