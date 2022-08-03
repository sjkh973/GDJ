package ex02_constructor;

public class User {
	
	private int userNo;
	private String id;
	private String email;
	
	public User(int userNo, String id, String email) {
		super();
		this.userNo = userNo;
		this.id = id;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", id=" + id + ", email=" + email + "]";
	}
	
	
	
}
