package ex01_anonymous_object.sec03;

public class Main {

	public static void main(String[] args) {
		
		Soil soil = new Soil();
		
		soil.sellOil(); 
		soil.sellOil();
		
		System.out.println(soil.getTotalOil());
		System.out.println(soil.getEarning());
		

	}

}
