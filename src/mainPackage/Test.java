package mainPackage;

public class Test {

	public static void main(String[] args) {
		 	  Car c1 = new Car("Golf 1", 7500, "Metallic", 2014);
	        Car c2 = new Car("Golf 2", 3500, "Metallic", 2007);
	        Car c3 = new Car("Golf 3", 4500, "Metallic", 2008);
	        Car c4 = new Car("Golf 4", 5500, "Metallic", 2009);

	        CarStore stack = new CarStore("Stack Motors"); // Kreiranje steka

	        stack.displayStack(); // Prikazuje da je stek prazan
	        System.out.println("-------------------");

	        stack.push(c1); // Dodaje c1 na vrh steka
	        stack.push(c2); // Dodaje c2 na vrh steka
	        stack.push(c3); // Dodaje c3 na vrh steka

	        stack.displayStack(); // Prikazuje c3 -> c2 -> c1
	        System.out.println("-------------------");

	        stack.pop(); // Skida c3 sa vrha
	        stack.displayStack(); // Prikazuje c2 -> c1
	        System.out.println("-------------------");

	        System.out.println("Peek: " + stack.peek()); // Prikazuje auto na vrhu (c2)
	        System.out.println("-------------------");

	        stack.push(c4); // Dodaje c4 na vrh steka
	        stack.displayStack(); // Prikazuje c4 -> c2 -> c1
	        System.out.println("-------------------");

	        System.out.println("Prosečna cena: " + stack.averagePrice()); // Računa prosečnu cenu
	        System.out.println("-------------------");

	        stack.addBiggerThanAvg(new Car("Tesla", 9000, "Black", 2022)); // Dodaje Teslu ako je cena > prosečne
	        stack.displayStack(); // Prikazuje stek sa dodatim automobilom (ako je uslov ispunjen)
    }
}
