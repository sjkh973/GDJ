package ex02_field;

public class SchoolMain {

	public static void main(String[] args) {

		School school = new School();
		
		school.name = "경인중학교";
		 
		Student student1 = new Student();
		student1.name = "한지민";
		student1.stuNo = "11025";
		Student student2 = new Student();
		student2.name = "김주성";
		student2.stuNo = "20152";
		
		school.students[0] = student1; 
		school.students[1] = student2;
		
		
		for(int i = 0; i < school.students.length;i++) {
			System.out.println(school.students[i].name);
			System.out.println(school.students[i].stuNo);
		}
	}

}
