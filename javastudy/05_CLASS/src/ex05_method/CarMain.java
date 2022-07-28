package ex05_method;

public class CarMain {

	public static void main(String[] args) {
		
		//객체생성
		Car car = new Car();
		
		car.addOil(50);
		car.addOil(5);
		car.addOil(100);
		
		car.pushAccel();
		car.pushAccel();
		
		System.out.println(car.oil);
		System.out.println(car.speed);
		
		car.pushBreak(); //25씩 줄어듬
		
		car.panel();
		
		
	
	}

}
