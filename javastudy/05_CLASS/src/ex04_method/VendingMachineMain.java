package ex04_method;

public class VendingMachineMain {

	public static void main(String[] args) {
		
		VendingMachine machine = new VendingMachine();

		// 커피 뽑기 시나리오
		// 한 잔 1000원 
		// 종류 : 1(아메리카노), 2(카페라떼)
		
		String coffee1 = machine.getCoffee(1000,1); //아메리카노 1잔
		String coffee2 = machine.getCoffee(2000,2); //카페라떼 2잔
		
		System.out.println(coffee1);
		System.out.println(coffee2);
	}

}
