package ex06_method_overload;

public class CalculatorMain {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		System.out.println(calculator.add(1, 1));
		System.out.println(calculator.add(1, 1, 1));
		System.out.println(calculator.add(1, 1, 1, 1));

		
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(calculator.add(arr));
	}

}
