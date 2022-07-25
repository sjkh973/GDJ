package ex04_input;

import java.util.Scanner;

public class Ex02_Scanner {

	public static void main(String[] args) {
		
		/*
		 * java.util.Scanner 클래스
		 * 데이터 타입별로 입력 받을 수 있는 메소드를 제공 
		 * int   : nextInt();
		 * long  : nextLong();
		 * double: nextdouble();
		 * String: nextline() <== 공백 포함가능, next(); < == 공백 포함 불가능
		 */
		
		Scanner sc = new Scanner(System.in); //객체 sc는 System.in(키보드)으로부터 입력을 받는다.
		
		System.out.print("이름을 입력하세요 >>> "  );
		String name = sc.next();
		
		System.out.print("나이를 입력하세요 >>> ");
		int age = sc.nextInt();
		
		System.out.println(name);
		System.out.println(age);
		
		sc.close(); // 가능
	}

}
