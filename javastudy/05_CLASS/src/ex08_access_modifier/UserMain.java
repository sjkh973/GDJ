package ex08_access_modifier;

public class UserMain {

	public static void main(String[] args) {

		User user = new User();
		
		System.out.println(user.getId());
		
		user.setId("admin");
		System.out.println(user.getId());	
		
		user.setPassword("1234");
		System.out.println(user.getPassword());
		
		user.setemail("sjkh972@naver.com");
		System.out.println(user.getemail());
		
		user.setpoint(10000);
		System.out.println(user.getpoint());
		
		System.out.println(user.getVip());
	}

}
