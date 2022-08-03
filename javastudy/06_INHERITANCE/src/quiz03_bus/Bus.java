package quiz03_bus;

public class Bus {
	
	private Seat[] seats; 	//배열 선언
	private int limit;		//버스 정원
	
	// Bus 생성자에서 배열 생성을 진행함
	public Bus(int cnt) {
		seats = new Seat[cnt]; //배열 생성 , new Bus(25)인 경우 Seat가 25개 생성됨
		limit = cnt;
		for(int i = 0; i < cnt; i++) {
			seats[i] = new Seat();
		}
	}
	
	// ride() 메소드
	public void ride(int seatNo, Person person) {
		//존재하지 않는 시트 번호
		if(seatNo <= 0 || seatNo > limit) {
			return;
		}
		// 시트에 사람이 없으면, 시트 번호에 탑승한 person 저장
		Seat seat = seats[seatNo -1];
		Person p = seat.getPerson();
			if(p == null) {
			seat.setPerson(person);
		}
		
	}
	
	// info() 메소드
	public void info() {
		for(int i = 0; i < limit; i++) { //limit 배열은 seats 배열의 length와 같음
			Seat seat = seats[i];
			Person person = seat.getPerson();  //Seat seat = seats[i]; 없애고 Person person = seats[i].getPerson();
			if(person != null) {
				System.out.println((i + 1) + "," + person.getName()); 
				//Person person = seat.getPerson(); 없애고
				//System.out.println((i + 1) + "," + seats[i].getPerson().getName());
			} else {
				System.out.println((i+1) + " , 비어 있음");
			}
			
		}
		
	}
	
	
	
	
}
