package ex01_random;

public class Ex01 {

	public static void main(String[] args) {
		
		/*
		 *  난수(Random number) 발생
		 *  Random 클래스 , Math 클래스를 주로 활용한다.
		 *  
		 */
		
		System.out.println(Math.random());
		
		//0.0 < = Math.random() < 1.0
		//0% < = Math.random() < 100%
		// 1.확률생성하기
		// 10%확률로 대박 90확률로 쪽박
		if(Math.random()<0.1) {
			System.out.println("대박");
		} else {
			System.out.println("쪽박");
		}
		
		// 2. 난수 값 생성
		// Math.random()      0.0 <= n <1.0
		// Math.random() * 5  0.0 <= n <5.0
		// (int)(Math.random() * 5) 0 <= n <5
		
		// 연습
		//주사위 2개
		
		
	
		
		for(int i = 0; i < 2;i++) {
			int dice1 = (int)(Math.random() * 6)+1;
			System.out.println("주사위" + dice1);
			
		}
		
		// 연습.
		// 6자리 숫자 인증 번호
		// ex) String code = "501924"
		String code = "";
		for(int i = 0; i<6; i++) {
			code += (int)(Math.random()*10);
		}
		System.out.println(code);
		
		//65에서 90사이의 값
		System.out.println((char)((int)(Math.random()*26) +'a'));
		
		//연습
		//6자리 영문(대문자 소문자 모두사용)
		 code = "";
		
		for(int i= 0;i<6;i++) {
			if(Math.random() < 0.5) {
				code += (char)((int)(Math.random() * 26) +'A');
			} else {
				code += (char)((int)(Math.random() * 26) +'a');
			}
			
		}
		System.out.println(code);
	}

}
