package ex01_setter;

public class Main {

	public static void main(String[] args) {
		
		//Bean - 값을 가지고 있는 객체
		
		User user = new User(); //User의 객체 user가 Bean or VO or DTO이다.
		
		user.setUserNo(1);
		user.setId("admin");
		user.setEmail("admin@naver.com");
		
		
		System.out.println(user); // 이게 되려면 User클래스에 toString을 오버라이드 해줘야함

	}

}
