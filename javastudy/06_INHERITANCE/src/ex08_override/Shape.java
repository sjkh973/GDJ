package ex08_override;

public class Shape {

	private String type; //도형의 종류

	public Shape(String type) {
		super();
		this.type = type;
	}

	public double getArea() {
		return 0;
	}
	
	public void info() {
		System.out.println("도형의 종류 : " + type);
	}
	
	
	
}
