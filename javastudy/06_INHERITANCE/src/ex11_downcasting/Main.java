package ex11_downcasting;

public class Main {

	public static void main(String[] args) {
		Car[] cars = new Car[10];
		
		//33퍼 확률로 cars[i]에 Car, Ev, Hybrid를 넣음
		for(int i = 0; i < cars.length; i++) {
			if(Math.random() < 0.33) {
				cars[i] = new Car();
			} else if(Math.random() < 0.66) {
				cars[i] = new Ev();
			} else {
				cars[i] = new Hybrid();
			}
		}
		/*
		 * car이면 drive() 호출
		 * Ev이면 charge() 호출
		 * Hybrid이면 addOil 호출
		 * 후손부터 먼저 체크해야 함
		 * 부모 클래스부터 체크 하게되면 아래 클래스들도 모두 부모 클래스에 속하기 때문에 if가 의미가 없음
		 */
		for(int i = 0; i < cars.length; i++) {
			if(cars[i] instanceof Hybrid) {  
				((Hybrid)cars[i]).addOil();
			} else if(cars[i] instanceof Ev) {
				((Ev)cars[i]).charge();
			} else if(cars[i] instanceof Car){
				cars[i].drive();
			}
		}
		
		
		
	}

}
