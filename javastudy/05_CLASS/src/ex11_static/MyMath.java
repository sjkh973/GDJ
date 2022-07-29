package ex11_static;

public class MyMath {
	
	//static
	// 1. 정적 요소
	// 2. 객체 생성 이전에 메모리에 미리 만들어지는 공동 요소
	// 3. 클래스에서 1개만 만들어 짐
	// 4. 클래스를 이용해서 호출하기 때문에 클래스 변수, 클래스 메소드라고 부름
	
	// 필드
	public static final double pI = 3.141592; //클래스 변수

	// 메소드
	public static int abs(int n) { //클래스 메소드
		//절대값 구하는 삼항연산자
		return  (n >= 0) ? n : -n;
	}
	
	public static int pow(int a ,int b) {
		// a의 b제곱 반환
		// for문 구현
		int result = 1;
		for(int i = 0; i < b; i++ ) {
			 result *= a;
		}
		return result;
	}
	
}
