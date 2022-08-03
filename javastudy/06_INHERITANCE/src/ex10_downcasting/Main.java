package ex10_downcasting;

public class Main {

	public static void main(String[] args) {
		
		//클래스타입 : Person
		//객체(인스턴스) : p
		Person p = new Alba(); //업캐스팅
		
		// instanceof 연산자
		// 특정 인스턴스가 어떤 클래스타입인지 점검하는 연산자
		// 해당 클래스타입이면 true 아니면 false
		
		System.out.println(p instanceof Person);
		System.out.println(p instanceof Student);
		System.out.println(p instanceof Alba);
		
		
		
		
		// p가 Student타입의 인스턴스이면 study 호출가능 = > p가 Student 타입의 객체인가
		if(p instanceof Student) {
			((Student) p).study();
		}
		
		// p가 Alba타입의 인스턴스이면 work()를 호출 할 수임있다.
		if(p instanceof Alba) {
			((Alba) p).work();
		}

	}

}
