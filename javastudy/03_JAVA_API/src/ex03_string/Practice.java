package ex03_string;

public class Practice {

	public static void main(String[] args) {
		
		// 연습 파일이름을 파일명과 확장자로 분리
		// 단, jpg, git, png 이미지인 경우에만 작업을 진행한다.
		
		// 연습 문자열 "abc12345def67890ghijk"에서
		// 아라비아 숫자 12345, 67890은 제외하고 한 글자씩 화면에 출력
		String str = "abc12345def67890ghijk";
		
		for(int i = 0; i< str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >= '0' && ch< '9') {
				continue;
			}
			System.out.println(ch);
		}
		
		
		//연습 대문자 6자리로 구성된 인증코드 작성하기
		StringBuilder sbCode = new StringBuilder();
		for(int i = 0; i < 6; i++) {
			sbCode.append((char)((int)(Math.random()*26)+'A'));		// 0 + 'A' <= Math.random() < 26 + 'A' == >  'A' <= Math.random() < 'A'(65) + 25

			}
	
		String strCode = sbCode.toString();
		System.out.println(strCode);
		
		// 연습 1 2 3 4 5 6 7 8 9 10 만들기
		StringBuilder sbpaging = new StringBuilder();
		for(int i = 1; i <= 10; i++) {
			sbpaging.append(i+" ");
		}
		String paging = sbpaging.toString();
		System.out.println(paging);
		
		// 연습 char 타입의 성별을 입력 받기
	}

}
