package ex02_loop;

public class Ex04_continue {

	public static void main(String[] args) {

		/* 
		 * continue문
		 * 반복문의 시작 지점으로 이동한다.
		 * 실행에서 제외할 코드가 있는 경우에 사용한다.
		 * 
		 * 1 ~ 100 중에서 3의배수를 제외하고 모두 더하기
		 * 
		 */
		int sum = 0;
		int i = 0;
		while(i < 100) {
			
			i++;
			
			if( i%3 == 0) {
				continue;
			}
			
			sum += i;
			
			
		}
		System.out.println("1부터 100의 3의배수를 제외한 수를 더하면: " + sum);

		sum = 0;
		i = 0;
		//continue 없이 코드를 만드는 건 언제나 가능하다.
		
		while(i < 100) {
			i++;
			if(i %3 != 0) {
				sum += i;
			}
			
		}

		System.out.println("sum: " + sum);
	}

}
