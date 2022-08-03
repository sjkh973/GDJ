package ex16_interface;

public class Person {

	public void foodFeed(Pet pet, String food) {
		
		System.out.println(pet.getPetName() + "에게 " + food + "주기");
	}

	// 인터페이스도 매개변수로 받을수 있다.
	// 타입으로 snake가 객체 생성되는것을 막는다.
	// able을 붙여놓은것은 인터페이스인것들이 많다.
	public void walk(Walkable pet) {
		//Walkable에 아무 메소드도 없기때문에 Pet타입으로 캐스팅 후 출력한다.
		System.out.println( ((Pet)pet).getPetName() + "와 산책");
	}
	
}
