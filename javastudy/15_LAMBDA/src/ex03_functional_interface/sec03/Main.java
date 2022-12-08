package ex03_functional_interface.sec03;

public class Main {

	public static void main(String[] args) {
		
		MyInterface3 my = () -> {
			int a =10; // 반환타입이 있기때문에 숫자형을 직접써줌 return 생략가능
			return a;
		}; 
		System.out.println(my.method());
		
		
		MyInterface3 you = () -> 20;
		System.out.println(you.method());
		
		
	}

}
