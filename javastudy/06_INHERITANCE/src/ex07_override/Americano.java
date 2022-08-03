package ex07_override;

public class Americano extends Espresso {
	
	private int extraWater;
	
	
	//빈곳에 커서를 두고 ctrl space 하면 override 자동완성있음
	// source 탭에도 override implement Methods로도 생성가능
	// 부모 클래스의 생성자를 기능 바꿔서 쓰는것을 override라고 함
	// 메소드명을 동일하게 해야한다.
	@Override
	public void taste() {
		// TODO 해야 할 일을 적어 둠
		System.out.println("덜 쓰다");
	}
	
	
}
