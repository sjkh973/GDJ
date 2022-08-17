package ex01_thread;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("main 시작");
		
		
		//Thread를 실행했을때 순서대로 실행되는게 아닌 나중에 실행될수도 있음
		Process process1 = new Process("연산");
		process1.start(); // Process 클래스의 오버라이드된 run() 메소드가 호출
		
		Process process2 = new Process("제어");
		process2.start();
		
		System.out.println("main 종료");
	}
}
