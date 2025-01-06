package mainPackage;

public class Test {

	public static void main(String[] args) {
		 	Car c1 = new Car("Golf 1", 7500, "Metallic", 2014);
	        Car c2 = new Car("Golf 2", 3500, "Metallic", 2007);
	        Car c3 = new Car("Golf 3", 4500, "Metallic", 2008);
	        Car c4 = new Car("Golf 4", 5500, "Metallic", 2009);
	        
	        System.out.println("Test klasa");
	        
	        System.out.println(c1.toString());
	        System.out.println("____________________________");
	        System.out.println(c2.toString());
	        System.out.println("____________________________");
	        System.out.println(c3.toString());
	        System.out.println("____________________________");
	        System.out.println(c4.toString());
    }
}
