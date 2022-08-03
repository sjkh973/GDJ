package ex08_override;

public class Circle extends Shape{

	private double radius; // 반지름

	public Circle(String type, double radius) {
		super(type);
		this.radius = radius;
	}

	@Override
	//부모클래스의 getArea를 쓸수없기때문에 override
	public double getArea() {
		// Math.pow  < == 제곱
		return Math.PI * Math.pow(radius, 2);
	}
	
	@Override
	public void info() {
		//부모 클래스의 info가 쓸수 있기때문에 
		//super.info()
		super.info();
		System.out.println("반지름 : " + radius);
		System.out.println("넓이 : " + getArea()); //메소드끼리 호출가능
	}
	
	
	
}
