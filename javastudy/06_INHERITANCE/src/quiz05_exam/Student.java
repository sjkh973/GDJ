package quiz05_exam;

public class Student {

	private String name;
	private Exam exam;
	
	public Student(String name) {
	
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Exam getExam() {
		return exam;
	}



	public void setExam(Exam exam) {
		this.exam = exam;
	}



	public void info() {
		System.out.println("학생이름 : " + name );
		exam.examInfo();
	}
}
