package ex03_method;

public class CalculatorMain {

	public static void main(String[] args) {
		
		//객체 생성
		Calculator calculator = new Calculator();
		
		// calculator 객체의 add() 메소드 호출
		// 1. 2, 3 : 인수(add 메소드로 전달하는 값) 인수는 매개변수에 저장된다.
		// 2. answer : add메소드의 반환값(return result)이 저장된다.
		
		
		System.out.println(calculator.add(1, 2));
	}

}
