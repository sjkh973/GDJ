package ex04_method;

public class VendingMachine {
	
	String getCoffee(int money, int button) {
		
		//아메리카노는 0 카페라떼는 1
		String[] menu = {"아메리카노","카페라떼"};
		
		//button -1로 menu배열의 인덱스를 뽑아내기
		return menu[button-1] + " " + (money / 1000) + "잔";
		
		//첫번째 인덱스에 빈값을줘서 1부터 가져올수있도록
		//String[] menu = {"","아메리카노","카페라떼"};
		//return menu[button] + " " + (money / 1000) + "잔";
		
	}
	
}
