package ex02_loop;

public class Ex02_while {

	public static void main(String[] args) {
		/*
		 * while 문
		 * 특정 실행문을 반복할 때 사용한다
		 * 특정 반복 횟수가 정해지지 않은 경우에 사용한다.
		 * while(조건문){
		 * 	실행문
		 * }
		 */ 
		int balance = 79350; //통장잔고
		int money = 450; //빠져나가는돈
		
		while(balance >= money) {
			System.out.println("잔액: " + balance + "인출액" + money);
			balance -= money;
		}
		System.out.println("잔액: " + balance);
	}

}
