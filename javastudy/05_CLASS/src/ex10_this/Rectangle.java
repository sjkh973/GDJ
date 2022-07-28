package ex10_this;

public class Rectangle {

	//필드
	private int width; //너비
	private int height; //높이
	
	
	// 생성자
	//직사각형
	public Rectangle(int width,int height) {
		this.width = width;
		this.height = height;
	}
	//정사각형
	public Rectangle(int n) {
		//this.width = n;
		//this.height = n;
		this(n, n); // //인수가 2개인 다른생성자 호출 
	}
	
	//메소드
	public int getArea() {
		return width * height;
		
	}
	
	public int getCircumference() {
		return  (width + height)*2;
	}
	
	
}
