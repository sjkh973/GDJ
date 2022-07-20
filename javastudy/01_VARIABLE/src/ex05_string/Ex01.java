package ex05_string;

public class Ex01 {

	public static void main(String[] args) {
		
		// 문자열 연결 연산
		// 문자열이 포함된 + 연산은 연결하는것임
		
		String str1 = "구디" + "아카데미";
		String str2 = 100 + "번지";
		String str3 = 1 + 1 + "행사";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		// + 연산을 이용한 문자열 만들기
		// 빈 문자열("")을 더 해주면 됨
		String str4 = 100+ ""; // String.valueOf(100)과 동일하다.
		System.out.println(str4);
		
		

	}

}
