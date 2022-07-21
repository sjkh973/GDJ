package ex02_loop;

public class Ex01_for {

	public static void main(String[] args) {

		/*
		 * for문 연속된 숫자를 생성할 때 주로 사용한다 배열과 함께 자주 사용된다. for(초기문;조건문;증감문){ 실행문 }
		 */

		// 1 ~ 10
		for (int n = 1; n <= 10; n++) {
			System.out.print(n + " ");
		}
		// 초기문 -> 조건문 -> 실행문 -> 증감문 -> 조건문 -> 실행문 ->증강문 ....
		System.out.println(); // 줄 바꿈

		// 연습
		// 10 ~ 1
		for (int i = 10; i >= 1; i--) {
			System.out.print(i + " ");
		}

		System.out.println();
		// 연습
		// 구구단 7단 출력

		// 내가한거
		int z = 7;
		for (int j = 1; j <= 9; j++) {
			z = j * 7;
			System.out.print(z + " ");
		}

		System.out.println();

		// 강사님이 한거
		for (int i = 1; i <= 9; i++) {
			System.out.println("7x" + i + "=" + (7 * i));
		}

		// 연습
		// 1 ~ 100 사이의 모든 3의배수만 출력하기
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		// 연습
		// 1 ~ 100 모든 정수 더하기
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("전체합은: " + sum);

		System.out.println();
		// 연습
		// begin ~ end 모든 정수 더하기
		// begin과 end중 누가 큰 지 모르는 상황
		// begin을 end보다 항상 작은 숫자로 바꾼 뒤 begin ~ end 모두 더하기 진행
		// begin이 end보다 크다면 begin과 end를 교환
		int begin = 100;
		int end = 1;
		int result = 0;

	
		 

		if (begin > end) {
			int temp;
			temp = begin;
			begin = end;
			end = temp;
		}

		int sum1 = 0;
		for (int n = begin; n <= end; n++) {
			sum1 += n;
		}
		System.out.println("begin+end : " + sum1);
		// 연습
		// 평점(1 ~ 5)에 따른 별 ★ 출력하기
		int point = 3;
		String star = "";
		for (int i = 0; i < point; i++) {
			star += "★";
		}
		System.out.println(star);

	}

}
