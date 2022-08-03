package quiz02_coffee;

public class Americano  {
	
	// 상속없이 Espresso를 사용
	
	private Espresso espresso; // Espresso를 객체로 선언
	private int shot;
	private String type;
	
	public Americano(Espresso espresso, int shot, String type) {
		super();
		this.espresso = espresso;
		this.shot = shot;
		this.type = type;
	}

	
	public void info() {
		
		espresso.info();
		System.out.println(shot + "샷");
		System.out.println(type + "아메리카노");
	}
	
	
	
}
