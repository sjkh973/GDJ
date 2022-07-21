package ex01_branch;

public class Ex05_practice {

	public static void main(String[] args) {
		
		//switch 연습문제
		
		// 연습
				// 각 층별 관리자를 출력하라
				// 1 ~ 2 전지현
				// 3 ~ 4 한지민
				// 5 ~ 6 박은빈
				// 나머지 아무나
				
		int floor = 1;
		String manager;
		//위에 숫자와 아랫숫자의 값이 동일 하므로 위의 case에 결과 값을 입력할 필요 없음
		switch (floor) {
		case 1:
		case 2: manager = "전지현";break;
		case 3:
		case 4: manager = "한지민";break;
		case 5:
		case 6: manager = "박은빈";break;
		default : manager = "아무나";

		}
		System.out.println(floor + "층의 관리자는 " + manager);
		
		System.out.println("=============================");
		//연습
		//짝수, 홀수
		int n = 1;
		
		switch (n%2) {
		case 0: System.out.println("짝수");break;
		default: System.out.println("홀수");
			
		}
		System.out.println("=============================");
		
		// 연습
		// 분기 출력하기
		// 1 ~ 3 월 : 1분기
		// 4 ~ 6 월 : 2분기 
		// 7 ~ 9 월 : 3분기
		// 10 ~ 12 월: 4분기
		int month = 12;
		//월 - 1 에 3을 나눠서 나온 몫으로 케이스 설정
		switch((month-1)/3) {
		case 0 : System.out.println("1분기");break;
		case 1 : System.out.println("2분기");break;
		case 2 : System.out.println("3분기");break;
		case 3 : System.out.println("4분기");break;
		
		}
		System.out.println("=============================");
		
		// 연습 . 
		// 점수에 따른 학점
		// 100 ~ 90 A
	    // 89 ~ 80 B
		// 79 ~ 70 C
		// 69 ~ 60 D
		// 59 ~ 0  F
		int score = 100 ;
		String grade;
		switch(score/10) {
		case 10 :
		case 9 : grade = "A";break;
		case 8 : grade = "B";break;
		case 7 : grade = "C";break;
		case 6 : grade = "D";break;
		default : grade = "F";
		
		}
		
		System.out.println(score + "는 " + grade + "학점");
		
		System.out.println("=============================");
		
			
				
				

	}

}
