package ex06_constructor;

public class Student extends Person{

	private String school;
	
	//Source탭 generate Constructor using field로 만들수 있다.
	public Student(String name, String school) {
		super(name);
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	
	
	
	
		
}
