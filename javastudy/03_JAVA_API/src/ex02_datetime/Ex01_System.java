package ex02_datetime;



public class Ex01_System {

	public static void main(String[] args) {
		
		/*
		 *  1. 타임스탬프(timestamp)
		 *  1970-01-01 0:00부터 1/1000초마다 증가하는 long타입의 정수값
		 */
		
		long timestamp = System.currentTimeMillis(); //milli second  
		System.out.println(timestamp);
		
		// 2. 나노타임(nanoTime)
		//  s >㎳(천분의 1초) > ㎲(백만분의 1초) > ㎱(십업분의 1초)
		// 나노초(ns)값을 가지는 long타입의 정수값
		//어떤 기준일자는 없어서 두 개의 나노초(ns) 사이의 경과시간 계산용
		long beginTime = System.nanoTime(); 
		int total = 1 + 2 + 3 + 4 + 5;
		long endTime = System.nanoTime();
		System.out.println(total + "계산에 걸린시간 : " + (endTime - beginTime)+"ns");
		System.out.println(beginTime);
		System.out.println(endTime);
	}

}
