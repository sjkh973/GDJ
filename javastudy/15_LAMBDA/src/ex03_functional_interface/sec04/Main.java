package ex03_functional_interface.sec04;

public class Main {
	
	public static void main(String[] args) {
		Calculator cal = (a, b) -> a + b;
		System.out.println(cal.add(1, 1));
		
	}
	
	
	
}
