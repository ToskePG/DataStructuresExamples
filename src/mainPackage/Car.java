package mainPackage;

public class Car {
	
	private String carBrand;
	private int carPrice;
	private String color;
	private int yearOfProduction;
	
	public Car(String carBrand, int carPrice, String color, int yearOfProduction) {
		this.carBrand = carBrand;
		this.carPrice = carPrice;
		this.color = color;
		this.yearOfProduction = yearOfProduction;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	@Override
	public String toString() {
		return "Car brand: " + carBrand + "\n" + "Car Price: " + carPrice + "\n" + "Car Color: " + color + "\n" + "Production year: "
				+ yearOfProduction;
	}

}
