package ex01_branch;

public class Ex01_if {

	public static void main(String[] args) {
		
		// if문
		//조건을 만족하는경웅에만 실행한다.
		// if(조건){
		//      실행문
		// }

		int score = 0;
		
		if(score >= 60) {  //실행문이 하나면 {} 생략가능
			System.out.println("합격");
			System.out.println("축하합니다.");
		}
		if(score < 60) { 
			System.out.println("불합격");
		}
		
		 
		
		
		
	}

}
