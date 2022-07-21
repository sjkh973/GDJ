package ex02_loop;

public class Ex03_break {

	public static void main(String[] args) {

		/*
		 * break문
		 * switch문을 종료할 때 사용한다.
		 * 반복문(for,while)을  종료할 때 사용한다.
		 * 
		 */
		
		// 모금 목표 : 100000
		// 한 번에 30원씩 모금
		
		// 1회 모금액 30원 현재 30원
		// 2회 모금액 30원 현재 60원 
		
		int total = 0;
		int money = 30;
		int goal = 100000;
		int serial = 0;
		while(true) { //무한 루프
			if(total >= goal) {
				break;
			}
			total += money;
			serial++;
			System.out.println(serial + "회 모금액"  + money + "원\t현재" + total + "원");
		}

		
	}

}
