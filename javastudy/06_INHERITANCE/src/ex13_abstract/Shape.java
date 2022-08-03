package ex13_abstract;

// 추상 메소드
// 1. 본문이 없는 메소드
// 2. 호출용으로 사용되는 메소드
// 3. 중괄호{} 자체를 없애고 세미콜론(;)을 추가함
// 4. public abstract(추천) 또는 abstract public

// 추상 클래스
// 1. 추상 메소드가 1개 이상 존재하는 클래스
// 2. public abstract class
// 3. 본문이 없는 메소드를 포함하기 때문에 객체 생성이 불허된다.
// 4. 추상 클래스를 상속 받는 클래스는 "반드시" "모든" 추상 메소드를 오버라이드 해야 함
public abstract class Shape {

	private String type;

	public Shape(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public abstract double getArea();  // Shape을 상속 받는 객체들이 호출할때 사용하는 메소드 
							 // 사용되지는 않는다. - > 추상 메소드로 바꿔준다.(본문이 없는 메소드)
		
	
}
