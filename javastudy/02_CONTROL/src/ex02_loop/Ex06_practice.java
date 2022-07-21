package ex02_loop;

public class Ex06_practice {

	public static void main(String[] args) {
		// 모금 목표 : 1000000
		// 한 번에 0부터 10000까지 랜덤 후원
		// 1회 모금액 n원 현재 ??원
		// 2회 모금액 n원 현재 ??원 
		// while문 사용하기
		int goal = 1000000;
		int total = 0;
		int count = 1;
		while(goal>=total) {
			
			int money = (int)(Math.random()*10000)+1; // 1 <= money <100001
			total+=money;
			count++;
			System.out.println(count+"회 " + "모금액: " + money + "  현재: " + total);
			}
		
		
		//별찍기 직각삼각형
		
		for(int i = 1; i <= 5;i++) {
			for(int j = 1; j <= i; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		//직각 삼각형 거꾸로
		
		for(int i = 1; i <= 5;i++) {
			for(int j = 5; j >= i; j-- ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("==================================");
		//구구단
		for(int i = 2; i<=9; i++) {
			for(int j = 1; j <= 9;j++) {
			   System.out.println(i + "x" + j + "=" + (i * j));
			}
			System.out.println();
		}
		//연습
		// 2x1 = 2
		// 2x2 = 4
		//...
		// 5x5 = 5 여기서 끝냄
		for(int i = 2; i<=5; i++) {
			for(int j = 1; j <= 9;j++) {
			   System.out.println(i + "x" + j + "=" + (i * j));
			   if(i == 5 && j == 5) {
					break;
				}
			}
			
			System.out.println();
		}
		
		
		
	}

}
