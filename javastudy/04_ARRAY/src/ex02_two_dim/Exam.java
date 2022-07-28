package ex02_two_dim;

public class Exam {

	public static void main(String[] args) {
		//문제1. String serial의 첫 번째 글자가 "1"이면 "남자" , "2"이면 "여자"를 출력하시오.
		String serial = "1234567";
		
		char ch = serial.charAt(0);
		
		if(ch == '1') {
			System.out.println("남자");
		} else if(ch == '2') {
			System.out.println("여자");
		}
		// 문제2. int a와 in b에 저장된 결과를 이횽해서 사칙연산 결과를 출력하시오.
		
		int a = 7;
		int b= 2;
		System.out.println("a + b :" + (a + b));
		System.out.println("a - b: " +  (a - b));
		System.out.println("a * b: " + a * b);
		System.out.println("a / b: " + (double)a / b);
		
		

	}

}
