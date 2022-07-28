package ex07_constructor;

public class Computer {

	/*
	 * 생성자(Constructor)
	 * 1. 객체 생성할 때 사용되는 특별한 메소드
	 * 2. 특징
	 * 	  1) 메소드 이름이 클래스 이름과 같다.
	 * 	  2) 반환타입이 존재하지 않는다.
	 * 3. 생성자는 필드 초기화 용도로 사용
	 * 
	 */
	
	/*
	 * 디폴트 생성자(Default Constructor)
	 * 1. 개발자가 생성자를 만들지 않으면 자바가 자동으로 생성하는 생성자
	 * 2. 아무 일도 안하는 형태
	 */
	//필드
	String model;
	int price;
	
	
	//생성자
	 
	Computer() {
				
	}
	
	Computer(String pModel,int pPrice) {
		model = pModel; //생성자가 전달받은값(매개변수)를 필드값에 전달
		price = pPrice;
		
	}
	
	void printComputerStatus() {
		System.out.println("모델: " + model);
		System.out.println("가격: " + price);
	}
	 
}
