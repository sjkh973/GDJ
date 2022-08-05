package ex05_throws;

public class ParkingLot {

	private Car[] cars;
	private int idx;
	
	public ParkingLot() {
		cars = new Car[10];
	}
	
	public void addCar() {
		
		try {
			if(idx == cars.length) {
				throw new RuntimeException("FULL");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public void deleteCar() {
		try {
			if(idx == 0) {
				throw new RuntimeException("EMPTY");
			}
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	
		
	}
	
	public void findCar() {
		
	}

	public void printAllCar() {
	
	}
	
	public void manage() {
	
			try {
				while(true) {
					int choice = 1;
					switch(choice) {
					case 1: addCar(); break;
					case 2: deleteCar(); break;
					case 3: findCar();break;
					case 4: printAllCar(); break;
					case 0: return;
					default : throw new RuntimeException("Bad Request");
					}	
				}
			}catch (RuntimeException e) {
				e.getMessage();
			}
	}
	
	public static void main(String[] args) {
		new ParkingLot().manage();
	
		
		
	}
}
