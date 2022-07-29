package ex11_static;

public class MyMathMain {

	public static void main(String[] args) {

		//Math math = new Math(); 는 객체를 못만들게 되어있음 만들어봤자 똑같은 기능이기 때문
		
		/*
		 * MyMath math1 = new MyMath();
		 * 
		 * System.out.println(math1.abs(-5));
		 * 
		 * MyMath math2 = new MyMath();
		 * 
		 * System.out.println(math1.abs(-8));
		 * 
		 * MyMath math3 = new MyMath();
		 * 
		 * System.out.println(math1.abs(12));
		 */
		
		//클래스변수, 클래스 메소드는 객체 선언 없이 사용가능하다 (Math.random())처럼
		System.out.println(MyMath.pI); 
		System.out.println(MyMath.abs(-5));
		
		System.out.println(MyMath.pow(2,5)); // 2의 5제곱(32)
		
		
		
	}

}
