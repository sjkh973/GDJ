package ex15_interface;

public class Main {

	public static void main(String[] args) {
		
		//메소드 호출 연습
		Phone p1 = new SmartPhone();
		System.out.println("전화기 기능");
		p1.call();
		p1.sms();
		((Computer) p1).game();
		((Computer) p1).internet();
		System.out.println(p1 instanceof Computer);
		System.out.println("===============");
		Computer p2 = new SmartPhone();
		System.out.println("컴퓨터 기능");
		p2.game();
		p2.internet();
		((Phone) p2).call();
		((Phone) p2).sms();
		
		System.out.println(p2 instanceof SmartPhone);
		System.out.println("===============");
		
		
		SmartPhone p3 = new SmartPhone();
		System.out.println("스마트폰 기능");
		p3.call();
		p3.sms();
		p3.game();
		p3.internet();
		System.out.println(p2 instanceof SmartPhone);
	}

}
