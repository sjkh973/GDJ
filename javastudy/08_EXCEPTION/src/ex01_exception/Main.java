package ex01_exception;

import java.util.Scanner;

public class Main {

	
	public static  void m1() {
		
		//NullPointerException : null 값이 어떤 메소드를 호출할 때 발생
		String[] hobbies = new String[5];
		
		hobbies[1] = "수영";
		hobbies[2] = "골프";
		hobbies[3] = "영화";
		hobbies[4] = "집콕";
		
		for(int i = 0; i < hobbies.length; i++) {
			if(hobbies[i].equals("수영")) {
				System.out.println("취미가 나와 같군요");
			}
		}
	}
	
	public static  void m2() {
	
		//NullPointerException : null 값이 어떤 메소드를 호출할 때 발생
				String[] hobbies = new String[5];
				
				hobbies[1] = "수영";
				hobbies[2] = "골프";
				hobbies[3] = "영화";
				hobbies[4] = "집콕";
				
				for(int i = 0; i < hobbies.length; i++) {
					if( hobbies[i] != null && hobbies[i].equals("수영")) {
						
						System.out.println("취미가 나와 같군요");
					}
				}
			}
	
	public static void m3() {
		//NumberFormatException : String을 Number타입으로 변경할 때 발생
		
		//NumberFormatException 회피
		Scanner sc = new Scanner(System.in);
		System.out.println("이름입력(필수)>>>");
		String name = sc.nextLine();
		System.out.println("나이입력(선택) >>>");
		String strAge = sc.nextLine(); // 입력 없이 Enger만 누르면 strAge는 빈 문자열을 가짐
		
		
		int age;
		if(strAge.isEmpty()){
			 age = 0;
		} else {
			age = Integer.parseInt(strAge);
		}
		System.out.println("이름: " + name + "나이: " + age + "살");
		
	}
		
	public static void m4() {
		
	}
		
	//static멤버는 static멤버만 부를수있다.
	//에러는 아래에서부터 위로 확인한다. == > stack trace
	public static void main(String[] args) {
		m3();
	}

}
