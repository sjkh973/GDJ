package quiz03_bus;

public class Main {
	public static void main(String[] args) {
		
		
		Bus bus = new Bus(25);
	
		bus.ride(1, new Person("kim"));
		bus.ride(1, new Person("lee"));
		bus.ride(5, new Student("choi"));
		bus.ride(10, new Alba("min"));
		
		bus.info();
		
	}
}
