package ex01_one_dim;

public class Ex01_array {

	public static void main(String[] args) {
		
		/*
		 *  배열(Array)
		 *  1. 여러 개의 변수를 하나의 이름으로 관리하는 자료 구조
		 *  2. 구성 요소
		 *  	1) 인덱스 : 각 변수의 위치 정보
		 *  	2) 배열명 : 모든 변수를 관리하는 하나의 이름
		 *  3. 각 변수는 배열명에 대괄호[]와 인덱스를 붙여서 구분
		 *  
		 *  배열 선언 및 생성
		 *  1. 배열 선언
		 *  	int[] arr;
		 *  	int arr[];
		 *  2. 배열 생성 
		 *  	arr = new int[3];
		 *  3. 배열 선언 및 생성
		 *  	int[] arr = new int[3];
		 *  
		 *  //배열 요소
		 *  1. 배열로 관리되는 각각의 변수
		 *  2. 모든 배열 요소의 호출
		 *  	arr[0]
		 *  	arr[1]
		 *  	arr[2] 
		 *  3. 배열 요소는 자동을 초기화 됨(값을 넣지 않아도 기본값을 가짐)
		 *  	값이 없음을 의미하는 0, 0.0, false, null값을 가진다.
		 *  
		 *  배열의 장점
		 *  * 변수 3개가 있는 상황
		 *  일반 변수 								배열
		 *  int a, b, c;       				int[] arr = new int[3];
		 *  System.out.println(a);			for(int i = 0; i < 3; i++){
		 *  System.out.println(b);              System.out.println(arr[i]);
		 *  System.out.println(c);			}
		 */
		
		int[] arr = new int[3];
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		arr[0] = 100;
		arr[1] = 50;
		arr[2] = 80;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		int total = 0;
		
		
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		double average = (double) total / arr.length;
		//double average2  =  total / 3.0; < == 실용성 x
		System.out.println("평균: " + average + "점" );
		
		

	}

}
