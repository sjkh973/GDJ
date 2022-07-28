package ex06_method_overload;

public class Calculator {

	// 메소드 오버로딩
	// 1. 같은 이름의 메소드가 2개 이상 존재한다.
	// 2. 같은 이름과 다른 매개변수를 가져야 오버로딩 할 수 있다.
	// 3. 반환타입은 오버로딩과 상관이 없다.
	
	
	int add(int a , int b) {
		return a+b;
	}
	
	int add(int a , int b, int c) {
		return a+b+c;
	}
	
	int add(int a , int b, int c ,int d) {
		return a+b+c+d;
	}
	int add(int[] arr) {
		int total = 0;
		for(int n : arr) {
			total += n;
		}
		return total;
	}
}
