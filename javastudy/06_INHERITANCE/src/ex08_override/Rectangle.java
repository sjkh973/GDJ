package ex08_override;

public class Rectangle extends Shape {
	
	//직사각형
	private double height;
	private double width;
	
	 public Rectangle(String type, double height, double width) {
		super(type);
		this.height = height;
		this.width = width;
	}
		
	@Override
	public double getArea() {	
		
		return height * width;
	}
	
	@Override
	public void info() {
		super.info();
		
		System.out.println("너비: " + width);
		System.out.println("높이: " + height);
		System.out.println("사각형의 넓이: " + getArea());
	}

	
	
	
 	
}