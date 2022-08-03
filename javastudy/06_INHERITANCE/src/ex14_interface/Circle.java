package ex14_interface;

public class Circle implements Shape{
	
	private double radius;
	
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}


	@Override
	public double getArea() {
		// PI는 인터페이스에 선언해둔 파이널 상수값
		return PI * Math.pow(radius, 2);
}
	
	
}
