package quiz03_bus;

public class Person {

	
	// 부모클래스는 공통적인 요소를 필드로 만들어준다.
	private String name;
	
	public Person(String name) {
		super();
		this.name = name;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
