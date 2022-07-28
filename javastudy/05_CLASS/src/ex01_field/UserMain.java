package ex01_field;

public class UserMain {

	public static void main(String[] args) {
		
		// 클래스 User(데이터 타입)      : User
		// 객체(변수개념, 인스턴스)      : user
		//동일한 패키지는 import안해도 됨
		
		//객체 선언
		//User user=null;
		
		//객체 생성
		//user = new User();
		
		//객체 선언과 생성을 한번에
		User user = new User();
		
		//모든 User 객체는 필드값을 가지고 있다.
		//마침표(.)을 이용해서 필드값을 호출한다.
		
		System.out.println(user.id);
		System.out.println(user.password);
		System.out.println(user.email);
		System.out.println(user.point);
		System.out.println(user.isVip);

		// 필드값 변경
		user.id = "admin";
		user.password = "123456";
		user.email = "admin@web.com";
		user.point = 10000000;
		user.isVip = (user.point >= 100000);
		System.out.println(user.id);
		System.out.println(user.password);
		System.out.println(user.email);
		System.out.println(user.point);
		System.out.println(user.isVip);
	}

}
