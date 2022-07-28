package ex02_is_a;

public class HybridMain {

	public static void main(String[] args) {

		Ev ev = new Ev();
		Hybrid hybrid = new Hybrid();
		
		ev.drive();
		ev.charge();
		
		hybrid.drive();
		hybrid.charge();
		hybrid.addOil();
		
		

	}

}
