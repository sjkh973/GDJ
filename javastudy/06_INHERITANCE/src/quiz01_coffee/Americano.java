package quiz01_coffee;

public class Americano extends Espresso {

	private String ice;
	public Americano(String coffee, int water, String ice) {
		super(coffee, water);
	
	}
	
	@Override
	public void info() {
		super.info();
		System.out.println(ice + "아메리카노");
	}
	
	
}
