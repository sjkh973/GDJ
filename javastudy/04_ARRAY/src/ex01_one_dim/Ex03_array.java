package ex01_one_dim;

import java.util.Arrays;
import java.util.concurrent.Delayed;

public class Ex03_array {
	public static void main(String[] args) {
		
		/*
		 * 배열의 데이터타입
		 * int[] : 참조타입(Reference Type)
		 * int[] arr = {1, 2, 3, };
		 * arr[0]부터 번지수가 멀어짐
		 *  
		 */
		
		/*
		 * 배열의 길이 늘리기
		 * 1. 배열의 길이는 변경할 수 없다.
		 * 2. 늘어난 길기의 새로운 배열을 만들고,
		 * 	  기존 배열의 값을 모두 새로운 배열로 옮기고,
		 * 	  기존 배열의 참조값을 새로운 배열의 참조값으로 수정한다. 
		 */

		// 길이가 5인배열을 사용하다가
		// 길이가 1000인 배열로 바꾸기
		int[] arr = {1, 2, 3, 4, 5};
		
		//늘어난 길이의 새로운 배열을 만들고,
		int[] temp = new int[1000];
		
		//기존 배열의 값을 모두 새로운 배열로 옮기고, System.arraycopy(기존배열,시작점,새로운배열,시작점,길이);
		System.arraycopy(arr, 0, temp, 0, arr.length);
		
		// 기존 배열의 참조값을 새로운 배열의 참조값으로 수정한다.
		arr = temp;
		
		
		// 이제 배열 arr 배열의 길이는 1000이다.
		System.out.println(arr.length);
		System.out.println(Arrays.toString(arr)); // Arrays.toString(배열) 배열의형태를 문자열로 바꿔주는 클래스 Arrays
		
		
	}
}
