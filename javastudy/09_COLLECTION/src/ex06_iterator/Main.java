package ex06_iterator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void m1() {
		
		// Iterator 인터페이스
		// 1. 특정 컬렉션(interface Collection)에 등록해서 사용
		// 2. 순회할 때 사용(for문 대용)
		// 3. 주요 메소드
		//	1) hasNext() : 남아 있는 요소가 있으면 true 반환
		//	2) next() : 요소를 하나 반환
		// 4. 주로 Set에서 사용
		
		
		Set<String> set = new HashSet<String>();
		
		set.add("제육");
		set.add("닭갈비");
		set.add("돈까스");
		set.add("김치찌개");
		 
		// set를 조회할 반복자 itr
		Iterator<String> itr = set.iterator();
		
		// hasNext() : 남아있는 요소가 있으면
		// next() : 그 요소를 꺼낸다.
		while(itr.hasNext()) {
			String element = itr.next();
			System.out.println(element);
		}
		
		
		
	}
	
	public static void m2() {
		
		/*
		 *  HashMap과 Iterator
		 *  1. keySet() 메소드로 key만 Set에 저장한다.
		 *  2. key를 저장한 Set에 Iterator를 등록해서 사용한다.
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("page", 1);
		map.put("column", "제목");
		map.put("query", "날씨");
		
		Set<String> keys = map.keySet();
			
		Iterator<String> itr = keys.iterator();
		
		while(itr.hasNext()) {
			String key = itr.next();
			Object value = map.get(key);
			System.out.println(key + ": " + value);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m2();
	}

}
