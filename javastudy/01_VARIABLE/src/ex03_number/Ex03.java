package ex03_number;

public class Ex03 {

	public static void main(String[] args) {
		
		/*
		 * 대입연산
		 */
		int score = 100; //등호(=)가 대입 연산자이다.
		
		// 연습
		// x에 10이 있고 y에 20이 있다. x와 y에 저장된 값을 서로 교환하시오
		
		int x = 10;
		int y = 20;
		int temp;
		
		temp = x; // temp = 10
		x = y; // x = 20 y = 20
		y = temp; // y = 10
		
		
		System.out.println("x" + x);
		System.out.println("y" + y);
		
		//복합 대입 연산자
		// +=, -=, *=, /=, %=
		int wallet = 0;
		wallet = wallet + 5000;
		wallet += 5000; //wallet = wallet + 5000;
		wallet -= 3000; //wallet = wallet - 3000;
		System.out.println(wallet);
		
		//연습
		//통장 잔액(balance)에서 이자 5%를 받았음을 나타내자.
		long balance = 10000;
		
		balance *= 1.05; //balance를 double로 promotion해서 처리한다.
		
		//balance = balance * 1.05; 실패 = >  balance * 1.05의 결과는 double이기 때문에 long타입인 balance에 저장할수 없다.
		
		//balance = (long)(balance * 1.05); 
		
		System.out.println(balance);
		
		//balance = balance + balance *0.0.5; 실패 = >  balance * 0.05의 결과는 double이기 때문에 long타입인 balance에 저장할수 없다.
		
		//balance = (long)(balance + balance * 0.05);long으로 강제 타입변환(casting)해서 저장할 수 있다.		
		balance += balance*0.05;
		
		
		
		
		
		

	}

}
