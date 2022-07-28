package ex08_access_modifier;

public class User {

		// 필드는 private이다.
	
		// private 필드는 같은 클래스에서만 사용가능
		private String id;  
		private String password;  
		private String email;  
		private int point;  
		private boolean isVip;  
		
		// 메소드는 public 이다.
		
		//아이디의 정보를 알려주는 메소드
		public String getId() {
			return id; // id값을 리턴해줌
		}    
		
		// 메인 클래스에서 전달받은 아이디정보를 User클래스의 필드에 전달해주는 메소드
		public void setId(String pId) {
			
			id = pId;
		}
		
		public String getPassword() {
			return password;
		}    
		
		public void setPassword(String pPassword) {
			
			password = pPassword;
		}
				
		public String getemail() {
			return email;
		}    
		
		public void setemail(String pEmail) {
			
			email = pEmail;
		}
		
		public int getpoint() {
			return point;
		}    
		
		public void setpoint(int ppoint) {
			point = ppoint;
			setVip(point >= 10000); //메소드안에서 메소드 호출가능
		}
		
		public boolean getVip() {
			return isVip;
		}    
		
		private void setVip(boolean pVip) {
			isVip = pVip;
		}
}
