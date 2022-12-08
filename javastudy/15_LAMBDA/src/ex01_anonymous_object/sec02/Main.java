package ex01_anonymous_object.sec02;

public class Main {

	public static void main(String[] args) {
		
		Soil soil = new Soil();
		
		soil.getCar().addOil();
		
		System.out.println(soil.getTotalOil());
		System.out.println(soil.getEarning());
		

	}

}
