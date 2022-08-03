package ex04_builder;

public class User {

	// 필드(Builder 객체가 가진 값을 받아 옴)
	private int userNo;
	private String id;
	private String email;
	
	// Builder 클래스의 build() 메소드가 호출하는 생성자
	public User(Builder builder) {
		this.userNo = builder.userNo;
		this.id = builder.id;
		this.email = builder.email;
	}
	
	//Builder 반환 메소드
	public static Builder builder() {
		return new Builder();
	}
	
	
	// User 클래스 내부에 Builder 클래스 생성
	// User 클래스를 이용해서 호출하기 위해 static 처리
	public static class Builder {
		
		// 내부필드(여기에 값을 전달 받아서 User의 필드로 보내는 원리)
		private int userNo;
		private String id;
		private String email;
		
		 // userNo() 메소드
		public Builder userNo(int userNo) {
			this.userNo = userNo;
			return this;
		}
		
		//id() 메소드
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		
		//email() 메소드
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		//build 메소드
		public User build() {
			return new User(this); //this는 Builder 객체(userNo, id, email)를 의미함
		}
	} //class Builder의 끝

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", id=" + id + ", email=" + email + "]";
	}
	
	
	
}

