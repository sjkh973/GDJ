package ex03_string;

public class Ex02_StringBuilder {

	public static void main(String[] args) {
		
		/*
		 * java.lang.StringBuilder 
		 */
		
		StringBuilder sb = new StringBuilder(); //문자열로 += 해주는 역할
		sb.append(1);
		sb.append(true);
		sb.append('T');
		sb.append(3.14);
		sb.append("hello");
		
		System.out.println(sb); //1trueT3.14hello
		
		// hello가 포함되었는가?
		
		//동등 비교
		System.out.println(sb.equals("1trueT3.14hello")); //sb는 String이 아닌 StringBuilder이므로 false이다.
		
		//StringBuilder로 만든 문자열은 반드시 마지막에 String으로 변환해야 함
		
		String result = sb.toString();  // StringBuilder변수.toString();  == > 문자열로 변환
		
		System.out.println(result);
		
		// String과 StringBuilder의 성능 테스트
		// abcdefghijklmnopqrstuvwxyz
		// StringBuilder가 더 빠르다
		String alphabet1 = "";
		long begin1 = System.nanoTime();
		for(char ch = 'a'; ch<= 'z'; ch++) { 		
			alphabet1 += ch;
		}
		
		long end1 = System.nanoTime();
		System.out.println("시간: " +(end1 - begin1+ " ")+alphabet1);
		
		System.out.println("========================================");
		
		StringBuilder sb2 = new StringBuilder();
		long begin2 = System.nanoTime();
		for(char ch = 'a'; ch <= 'z'; ch++) {
			sb2.append(ch);
		}
		long end2 = System.nanoTime();
		String alphabet2 = sb2.toString();
		System.out.println("시간: " + (end2 - begin2+ " ") + alphabet2);
		
		
	}

}
