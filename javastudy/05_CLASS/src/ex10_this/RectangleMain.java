package ex10_this;

public class RectangleMain {

	public static void main(String[] args) {
		
		//직사각형
		Rectangle rect1 = new Rectangle(3,4);
				
		//정사각형
		Rectangle rect2 = new Rectangle(5);

		System.out.println("넓이: " + rect1.getArea());
		System.out.println("둘레: " + rect1.getCircumference());
		
		System.out.println("넓이: " + rect2.getArea());
		System.out.println("둘레: " + rect2.getCircumference());
	}

}
