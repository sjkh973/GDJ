package ex03_string;

import java.util.Scanner;

public class Ex01_String {

	public static void main(String[] args) {

		String str1 = "Hello";
		String str2 = "Hello";
		
		System.out.println(str1 == str2 );
		
		String str3 = new String("hi");
		String str4 = new String("hi");
		
		System.out.println(str3 == str4);
		
		System.out.println("1. =================");
		// 1. 문자열 동등 비교 메소드 (.equals)
		boolean result1 = str1.equals(str2);
		boolean result2 = str3.equals(str4);
		System.out.println(result1);
		System.out.println(result2);
		
		if(str1.equals(str2)) {
			System.out.println("str1, str2는 같다");
		} else {
			System.out.println("str1, str2는 다르다");
		}
		
		if(!str3.equals(str4)) {
			System.out.println("str3, str4는 다르다");
		} else {
			System.out.println("str3, str4는 같다");
		}
		
		System.out.println("2. =================");
		// 2. 대소문자를 무시한 문자열 동등 비교 (.equalsIgnoreCase)
		String str5 = "Hello World";
		String str6 = "hELLO wORLD";
		boolean result3 = str5.equalsIgnoreCase(str6); // upperCase lowerCase 무시
		System.out.println(result3);
		
		System.out.println("3. =================");
		// 3. 문자열 길이 반환
		String name = "김주성";
		String name2 = "김주성";
		int length = name.length();
		System.out.println("글자수 : " + length);
		
		System.out.println("4. =================");
		// 4. 특정 위치의 문자(char)만 반환 (변수.charAt(인덱스 숫자))
		// 특정 위치
		// 인덱스(Index)라고 함
		// 글자마다 부여된 정수
		// 0에서 시작
		System.out.println(name.charAt(0));
		System.out.println(name.charAt(1));
		System.out.println(name.charAt(2));

		
		System.out.println("5. =================");
		
		// 5. 문자열의 일부 문자열(String)을 반환 (변수.substring(인덱스숫자))
		// 1) substring(begin) : 인덱스 begin(포함)부터 끝까지 반환
		// 2) substring(begin,end) : 인덱스 begin(포함)부터 인덱스 end(불포함)까지 반환
		
		System.out.println(name.substring(0,1));
		System.out.println(name.substring(1));
		
		System.out.println("6. =================");
		// 6. 특정 문자열을 찾아서 해당 인덱스(int)를 반환 (변수.indexOf("문자열"))
		// 	  1) indexOf
		// 		(1) 발견된 첫 번째 문자열의 인덱스를 반환			
		//		(2) 발견된 문자열이 없는 경우 -1을 반환
		//	  2) lastIndexOf
		//		(1) 발견된 마지막 문자열의 인덱스를 반환
		//		(2) 발견된 문자열이 없는경우 -1을 반환
		
		int idx1 = name.indexOf("김");
		int idx2 = name.indexOf("주성");
		
		int idx3 = name2.lastIndexOf("김");
		int idx4 = name2.lastIndexOf("주성");
		
		System.out.println(idx1);
		System.out.println(idx2);
		System.out.println("=========");
		System.out.println(idx3);
		System.out.println(idx4);
		
		System.out.println("7. =================");
		// 7. 문자열이 특정 패턴으로 시작하는지 boolean 반환
		//	변수.startWith(문자열)
		
		if(name.startsWith("김")) {
			System.out.println("김씨입니다.");
		} else {
			System.out.println("아닙니다.");
		}
		
		System.out.println("8. =================");
		// 8. 문자열이 특정 패턴으로 끝나는지 boolean 반환
			//	변수.endWith(문자열)
		String filename = "image.jpg";  // jpg png
		
		
		if(filename.endsWith("jpg") || filename.endsWith("png")) {
			System.out.println("이미지입니다.");
		} else {
			System.out.println("아닙니다.");
		}
		
		System.out.println("9. =================");
		// 9. 문자열이 특정 패턴을 포함하는지 boolean 반환 (변수.contains(포함여부 확인할 문자열))
		String email = "sjkh972@naver.com";
		
		if(email.contains("@") && email.contains(".")) {
			System.out.println("이메일입니다.");
		} else {
			System.out.println("이메일 아닙니다.");
		}
		
		System.out.println("10. =================");
		// 10. 불필요한 공백 제거(좌우 공백) (변수.trim())
		String message = " 안녕  하세요  ";
		System.out.println(message.trim()); // 안녕과 하세요의 사이의 공백은 제거 되지않음
		System.out.println(message.trim().length()); // 공백을 제거 한 후의 문자열의 갯수
		
		System.out.println("11. =================");
		// 11. 대문자 변환하기 (변수.toUpperCase)
		// toUpperCase() : 대문자로 변환하기
		// toLowerase()  : 소문자로 변환하기
		// 변환 했을 때 변수값이 바뀌진 않음
		String source = "best of best";
		System.out.println(source.toUpperCase()); 
		System.out.println(source.toLowerCase());
		
		System.out.println("12. =================");
		// 12. 찾아 바꾸기
		//replace(old,new) <== old를 찾아서 new로 바꿈
		// 변환 했을 때 변수값이 바뀌진 않음
		String replaced = source.replace("best", "worst"); //변환한 값을 replaced에 저장
		System.out.println(source);
		System.out.println(replaced);
		
		System.out.println("=================");
		//주의. replaceAll() 메소드는 특정 문자열을 찾아서 변환하는 것이 아님.
		String ip = "192.168.101.91";
		String replcedIp = ip.replaceAll(".", "_"); // 192_168_101_91를 기대하지만 전부다 _로 바뀜
		System.out.println(replcedIp);
		
		System.out.println("13. =================");
		// 빈 문자열인지 여부를 검사한 뒤 boolean 반환 (변수.isEmpty)
		String id = " ";
		if(id.trim().isEmpty()) { //공백을 제거 한 후 빈문자열인지 검사
			System.out.println("빈 문자열");
		} else {
			System.out.println("빈 문자열 아님");
		}
		
		//if(id.isBlank()) { // 11버전에서만 사용가능한 메소드 공백이 있어도 빈 문자열로 처리
			//System.out.println("빈 문자열");
		//} else {
			//System.out.println("빈 문자열 아님");
		//}
		System.out.println("========연습=========");
		System.out.println();
		// 연습 파일이름을 파일명과 확장자로 분리
		// 단, jpg, git, png 이미지인 경우에만 작업을 진행한다.
		String fullname = "apple.jpg";
		String fileName = ""; // apple
		String extName = ""; // jpg 
		
		if(fullname.endsWith(".jpg") || fullname.endsWith(".git") || fullname.endsWith(".png") ) {
			 fileName = fullname.substring(0,fullname.indexOf("."));
			System.out.println("fileName: " + fileName);
			extName = fullname.substring(fullname.indexOf("."));
			System.out.println("extName: " + extName);
			
		} else {
			System.out.println("올바른 확장자가 아님");
		}
		
		int idxOfDot = fullname.lastIndexOf(".");
		fileName = fullname.substring(0,idxOfDot);
		extName = fullname.substring(idxOfDot+1);
		System.out.println("fileName: " + fileName);
		System.out.println("extName: " + extName);
		System.out.println("idxOfDot "+ idxOfDot );
		
		System.out.println("======================================================================");
		System.out.println();
		// 연습 문자열 "abc12345def67890ghijk"에서
		// 아라비아 숫자 12345, 67890은 제외하고 한 글자씩 화면에 출력
		String str = "abc12345def67890ghijk";
		
		for(int i = 0; i < str.length() ; i++) {
			char ch = str.charAt(i);
			if(ch >= '0' && ch <= '9') { // &&코드는 사이값을 구하는 코드
				continue;
			} 
			System.out.println(ch);
		}
		
		System.out.println("======================================================================");
		System.out.println();
		//연습 대문자 6자리로 구성된 인증코드 작성하기
		StringBuilder sbCode = new StringBuilder();
		for(int n = 0; n < 6; n++) {
			sbCode.append((char)((int)(Math.random() * 26)+'A'));
		}
		
		String code = sbCode.toString();
		System.out.println("인증코드 : " + code);
		
		
		
		System.out.println("======================================================================");
		System.out.println();
		// 연습 1 2 3 4 5 6 7 8 9 10 만들기
		
		StringBuilder sbpaging = new StringBuilder();
		for(int n = 1; n <=10; n++) {
			sbpaging.append(n+ " ");
		}
		String paging = sbpaging.toString();
		System.out.println("paging: " + paging);
		
		System.out.println("======================================================================");
		System.out.println();
		// 연습 char 타입의 성별을 입력 받기
		
		System.out.println("성별(남/여)을 입력하세요>>>");
		
		Scanner sc = new Scanner(System.in);
		char gender = sc.next().charAt(0); //스캐너로 String 타입으로 입력받은뒤 charAt() 메소드를 입력하여 char로 변경
		System.out.println(gender);
		
		
		
	}

}
