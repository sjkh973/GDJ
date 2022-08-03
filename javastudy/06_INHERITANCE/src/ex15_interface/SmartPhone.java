package ex15_interface;

//2개를 상속하려면 하나는 abstract 클래스 하나는 인터페이스로 해준다.

//상속(extends) 먼저, 구현(implements) 나중
//인터페이스는 2개이상가능  implements interface1, interface2
public class SmartPhone extends Phone implements Computer { 

	@Override
	public void call() {
		System.out.println("전화기능");		
	}
	@Override
	public void game() {
		// TODO Auto-generated method stub
		System.out.println("게임기능");
	}
	@Override
	public void internet() {
		// TODO Auto-generated method stub
		System.out.println("인터넷기능");
	}
	@Override
	public void sms() {
		// TODO Auto-generated method stub
		System.out.println("문자기능");
	}
}
