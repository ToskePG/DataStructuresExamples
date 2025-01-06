package mainPackage;

public class Test {

	public static void main(String[] args) {
        Car c1 = new Car("Golf 1", 7500, "Metallic", 2014);
        Car c2 = new Car("Golf 2", 3500, "Metallic", 2007);
        Car c3 = new Car("Golf 3", 4500, "Metallic", 2008);
        Car c4 = new Car("Golf 4", 5500, "Metallic", 2009);
        Car c5 = new Car("Golf 5", 6500, "Metallic", 2010);

        CarStore queue = new CarStore("Circular Queue Motors", 4); // Kreiranje reda sa kapacitetom 4

        queue.displayQueue(); // Prikazuje da je red prazan
        System.out.println("-------------------");

        queue.enqueue(c1); // Dodaje c1 u red
        queue.enqueue(c2); // Dodaje c2 u red
        queue.enqueue(c3); // Dodaje c3 u red

        queue.displayQueue(); // Prikazuje c1 -> c2 -> c3
        System.out.println("-------------------");

        queue.dequeue(); // Uklanja c1 iz reda
        queue.displayQueue(); // Prikazuje c2 -> c3
        System.out.println("-------------------");

        System.out.println("Peek: " + queue.peek()); // Prikazuje auto na početku reda (c2)
        System.out.println("-------------------");

        queue.enqueue(c4); // Dodaje c4 u red
        queue.enqueue(c5); // Pokušava da doda c5, ali red je pun
        queue.displayQueue(); // Prikazuje c2 -> c3 -> c4
        System.out.println("-------------------");

        System.out.println("Average Price: " + queue.averagePrice()); // Računa prosečnu cenu
        System.out.println("-------------------");

        queue.addBiggerThanAvg(new Car("Tesla", 9000, "Black", 2022)); // Dodaje Teslu ako je cena > prosečne
        queue.displayQueue(); // Prikazuje red sa dodatim automobilom (ako je uslov ispunjen)
    }
}
