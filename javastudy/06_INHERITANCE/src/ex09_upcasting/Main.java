package ex09_upcasting;

public class Main {

	public static void main(String[] args) {
		
		//Up Casting
		//슈퍼 클래스 객체 = new 서브 클래스();
		// 자식 객체들을 전부 슈퍼클래스로 저장가능하다.
		// 자식 객체들의 메소드는 사용불가
		// 슈퍼 클래스에 자식 클래스의 메소드를 작성하여 사용 가능
		
		Person alba = new Alba();
		alba.eat();
		alba.study(); //슈퍼 클래스의 메소드를 불러오고 자식메소드들이 override되서 실행된다.
		alba.work();
		
		//new Student()와 new Alba()는 모두
		//Person 타입으로 처리할 수 있다.
		
		// 한 교실에 Student와 Alba가 섞여 있다.
		// 어떻게 처리할 것인가?
		// Person 타입의 배열을 이용해서 모두 처리할 수 있다.
		
		Person[] people = new Person[10];
		
		people[0] = new Alba();
		people[1] = new Alba();
		people[2] = new Student();
		
		
		for(int i = 0; i < people.length; i++) {
			if(people[i] != null) {
			people[i].eat();
			people[i].study();
			people[i].work();
			System.out.println();
			}
		}
		
		for(Person person : people) {
			if(person != null) {
				person.eat();
				person.study();
				person.work();
				System.out.println();
			}
		}
		
		
	}

	
}
