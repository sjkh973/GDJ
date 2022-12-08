package ex02_lambda.sec02;

public class Main {

	public static void main(String[] args) {
		
		Soil soil = new Soil();
		
		soil.getCar().addOil();
		
		System.out.println(soil.getTotalOil());
		System.out.println(soil.getEarning());
		

	}

}
