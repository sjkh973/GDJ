package ex08_override;

public class Main {

	public static void main(String[] args) {
		
		Circle circle = new Circle("도넛", 7.5);
		
		circle.info();

		Rectangle rectangle = new Rectangle("직사각형", 7, 4);
		rectangle.info();
		
		System.out.println("=================================");
	
		Square square = new Square("정사각형", 5);
		square.info(); //부모클래스의 info 메소드 호출
		
		
	}

}
