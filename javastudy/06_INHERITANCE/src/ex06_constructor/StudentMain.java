package ex06_constructor;

public class StudentMain {

	public static void main(String[] args) {
		
		Student student = new Student("tom", "goodee");
		
		System.out.println(student.getName()); //부모 클래스에 있는 필드 호출가능
		System.out.println(student.getSchool()); 
		
		Alba alba = new Alba("jessica", "seoul univ", "library");
		
		System.out.println(alba.getName());
		System.out.println(alba.getSchool());
		System.out.println(alba.getCompany());
		
		
	}

}
