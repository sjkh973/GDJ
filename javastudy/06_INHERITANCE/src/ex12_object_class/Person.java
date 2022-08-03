package ex12_object_class;

public class Person {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println("먹는다.");
		
	}

	//source탭에 generate tostirng으로 생성
	@Override
	public String toString() {
		return "이름: " + name ;
	}
	
	
	
	
	
	
}
