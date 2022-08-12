package ex02_writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONWriter {

	public static void m1() {
		/*
		 * JSON
		 * 1. JavaScript Object Notation
		 * 2. 자바 스크립트 객체 표기법
		 * 3. 객체 : {}
		 * 4. 배열 : []
		 * 
		 * JSON-Java(JSON in Java) 라이브러리
		 * 1. 객체 : JSONObejct 클래스를 사용(Map 기반)
		 * 2. 배열 : JSONArray 클래스를 사용(List 기반 ArrayList와 사용법이 유사함)	
		 */ 
		
		JSONObject obj = new JSONObject();
		
		//map 형태
		obj.put("name", "김주성");
		obj.put("age", "29");
		obj.put("man", "true");
		obj.put("height", "180.5");
		System.out.println(obj.toString());
	}
	
	public static void m2() {
		
		JSONObject obj1 = new JSONObject();
		obj1.put("name", "제임스");
		obj1.put("age", 30);
		
		
		JSONObject obj2 = new JSONObject();
		obj2.put("name", "에밀리");
		obj2.put("age", 40);
		
		JSONArray arr = new JSONArray();
		arr.put(obj1);
		arr.put(obj2);
		
		System.out.println(arr.toString());
	}
	
	public static void m3() {
		
		String str = "{\"name\":\"김주성\",\"man\":\"true\",\"age\":\"29\",\"height\":\"180.5\"}"; //공공 api데이터형식이랑 유사함 
		
		JSONObject obj =  new JSONObject(str);
		
		String name = obj.getString("name"); //Key값을 가져오는 것
		boolean man = (boolean) obj.getBoolean("man");
		int age = (int)obj.getInt("age");
		double height = (double)obj.getDouble("height");
		
		System.out.println(name);
		System.out.println(man);
		System.out.println(age);
		System.out.println(height);
	}
	
	public static void m4() {
		
		String str = "[{\"name\":\"제임스\",\"age\":30},{\"name\":\"에밀리\",\"age\":40}]";
		
		JSONArray arr = new JSONArray(str);
		
		
		// 일반 for문
		for(int i = 0, length = arr.length(); i < length; i++) {
			JSONObject obj =  arr.getJSONObject(i); // 배열의 jsonObject(객체)를 가져옴 < = 중괄호 하나의 값이 하나의 객체
			String name =obj.getString("name");
			int age = obj.getInt("age");
			System.out.println(name + ":" + age);
		}
		//향상 for문 : get() 메소드로 동작. get() 메소드는 Object를 반환.
		for(Object o : arr) {
			JSONObject obj = (JSONObject)o;
			String name = obj.getString("name");
			int age = obj.getInt("age");
			System.out.println(name + ":" + age);
		}
	
		
	}
	
	public static void main(String[] args) {
		 
		List<String> product1 = Arrays.asList("100", "새우깡", "1500");
		List<String> product2 = Arrays.asList("101", "양파링", "2000");
		List<String> product3 = Arrays.asList("102", "홈런볼", "3000");
		
		List<List<String>> list = Arrays.asList(product1, product2, product3);
		
		// list를 json String으로 만들어서
		// C:\\storage\\product.json 파일에 write()
		
		//Collection은 list나 set이다
		JSONArray arr = new JSONArray();
		
		//line 하나를 object로 바꿔줘야함 product1이 object
		for(List<String> line: list) {
			JSONObject obj = new JSONObject();
			obj.put("number", line.get(0)); // line의 첫번째 요소
			obj.put("name", line.get(1));
			obj.put("price", line.get(2));
			
			arr.put(obj);
		}
		
		System.out.println(arr.toString());
		
		File file = new File("C:\\storage", "product.json");
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(arr.toString());		
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null ) {
					bw.close();
				}
			}catch (IOException e) {			
				e.printStackTrace();
			}
		}
		
		
		
	}

}
