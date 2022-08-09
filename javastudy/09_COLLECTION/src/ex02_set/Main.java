package ex02_set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	
	public static void m1() {
		
		//세트 생성
		Set<String> set = new HashSet<String>();
		
		//요소 추가
		// 동일한 값 저장 불가
		set.add("일");
		set.add("월");
		set.add("화");
		set.add("수"); 
		set.add("수"); //중복 저장 시도
		
		// 요소 제거
		boolean result = set.remove("일");
		System.out.println(result);
		
		//세트확인
		System.out.println(set);
		
	}
	
	public static void m2() {
		
		// 세트의 초기화
		// 리스트를 세트로 변환하는 방식으로 초기화 진행
		
		Set<String> set = new HashSet<String>(Arrays.asList("일", "월", "화", "수"));
		
		// 세트의 길이
		int size = set.size();
		System.out.println(size);
		
		// 향상 for문 가능(인덱스가 없으므로 일반 for문 불가능)
		for(String element : set) {
			System.out.println(element);
		}
	}

	public static void m3() {
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3, 4, 5, 6, 7));
		Set<Integer> set3 = new HashSet<Integer>(Arrays.asList(6, 7));
		
		// 교집합
		// 교집합 결과는 retainAll 메소드를 호출한 Set에 저장
		// set1.retainAll(set2);
		// System.out.println(set1);
		
		// 합집합
		// 합집합 결과는 addAll 메소드를 호출한 Set에 저장
		//set1.addAll(set2);
		//System.out.println(set1);
		
		
		// 차집합
		// 차집합 결과는 removeAll 메소드를 호출한 Set에 저장
		set1.removeAll(set2);
		System.out.println(set1);
		
		// 부분집합 여부 판단
		boolean result1 = set1.containsAll(set3); //set3가 set1의 부분집합이면 true
		boolean result2 = set2.containsAll(set3); //set3가 set2의 부분집합이면 true
		System.out.println(result1);
		System.out.println(result2);
		
	}
	
	public static void m4() {
		
		//중복 요소가 있는 리스트 - > 세트 변환 - > 다시 리스트로 변환
		
		List<String> list = new ArrayList<String>();
		list.add("일");
		list.add("월");
		list.add("화");
		list.add("화");
		
		Set<String> set = new HashSet<String>(list);
		
		list.clear(); // 리스트 요소 모두 제거
		
		list = new ArrayList<String>(set);
		
		System.out.println(list);
		
	}
	
	public static void main(String[] args) {
		m4();		
	}

}
