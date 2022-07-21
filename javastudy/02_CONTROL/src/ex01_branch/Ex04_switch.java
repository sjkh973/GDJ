package ex01_branch;

public class Ex04_switch {

	public static void main(String[] args) {

		// switch문
		// 표현식의 결가 값에 따른 분기를 처리한다.
		// 표현식의 결과 값은 double boolean 데이터타입일 수 없다.
		// switch(표현식){
		//		case 값 : 실행문; break;
		//		case 값 : 실행문; break;
		// 		default : 실행문;
		// }
		int step = 1;
		
		switch (step) {
		
		case 1: System.out.println("1단계"); break;
		case 2: System.out.println("2단계"); break;
		case 3: System.out.println("3단계"); break;
		default: System.out.println("잘못된 단계");
		}
		
		System.out.println("========================");
		// 연습
		// 각 층별 관리자를 출력하라
		// 1 ~ 2 전지현
		// 3 ~ 4 한지민
		// 5 ~ 6 박은빈
		// 나머지 아무나
		
		int floor = 1;
		String manager;
		
		switch (floor) {
		case 1: 
		case 2: manager = "전지현";break;
		case 3: 
		case 4: manager = "한지민";break;
		case 5: 
		case 6: manager = "박은빈";break;
		default: manager = "박보검";
		}
		
		System.out.println(floor + "층의 관리자는 "  + manager + "입니다.");
		
		
		System.out.println("========================");
		
		//연습
		//짝수, 홀수
		int n = 1;
		switch (n % 2) {
		case 0 : System.out.println("짝수");break;
		default : System.out.println("홀수");
		}
		
		// 연습
		// 분기 출력하기
		// 1 ~ 3 월 : 1분기
		// 4 ~ 6 월 : 2분기 
		// 7 ~ 9 월 : 3분기
		// 10 ~ 12 월: 4분기
		int month = 12;
		//월 - 1 에 3을 나눠서 나온 몫으로 케이스 설정
		switch ((month - 1) / 3) {
		case 0 : System.out.println("1분기"); break;
		case 1 : System.out.println("2분기"); break;
		case 2 : System.out.println("3분기"); break;
		case 3 : System.out.println("4분기"); break;
		}
		
		System.out.println("========================");
		// 연습 . 
		// 점수에 따른 학점
		// 100 ~ 90 A
	    // 89 ~ 80 B
		// 79 ~ 70 C
		// 69 ~ 60 D
		// 59 ~ 0  F
		int score = 100 ;
		String grade;
		
		switch ( score / 10 ) {
		case 10 :
		case 9  : grade = "A";break;
		case 8  : grade = "B";break;
		case 7  : grade = "C";break;
		case 6  : grade = "D";break;
		default : grade = "F";break;
		}
		
		System.out.println(score + "점은" + grade + "학점입니다.");
		
		
		System.out.println("========================");
		
		//연습
		// 등급(1,2,3)에 따른 권한 출력
		// 1등급 : 쓰기 실행 읽기
		// 2등급 : 실행 읽기
		// 3등급 : 읽기
		// 나머지 : 없음
		
		int level = 1;
		String right = ""; //권한
		
		switch ( level ) {
		case 1 : right += "쓰기";
		case 2 : right += "실행";
		case 3 : right += "읽기"; break;
		default : right = "없음";
		}
		
		System.out.println(level+"등급의 " + "권한은 " + right );
	}
}
