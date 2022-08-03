package ex07_override;

public class Espresso extends Coffee {

	// 에스프레소에 extra Water를 추가하면 Americano
	//에스프레소에 milk를 추가하면 CafeLatte
	// 각 taste() 작성
	
	@Override
	public void taste() {
		System.out.println("쓰다");
	}
}
