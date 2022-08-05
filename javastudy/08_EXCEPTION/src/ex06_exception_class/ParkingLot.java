package ex06_exception_class;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ParkingLot {

	private Car[] cars;
	private int idx;
	private Scanner sc;
	public ParkingLot() {
		
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
	public void addCar() throws MyException {
		if(idx == cars.length) {
			throw new MyException("FULL", 1000); // 에러코드 1000
		}
	}	
	public void deleteCar() throws MyException {
		if(idx == 0) {
			throw new MyException("EMPTY", 2000); // 에러코드 2000
		}
		
	}	
	public void manage() {
		while(true) {
			try {
				System.out.println("1.추가 2. 삭제 3. 종료>>>");
				int choice = sc.nextInt();
				switch(choice) {
				case 1: addCar(); break;
				case 2: deleteCar();break;
				case 0: return;
				default : throw new RuntimeException("Bad Request");
				}
				
				
			}catch (MyException e) {
				System.out.println(e.getMessage() + "[" + e.getErrorCode() + "]");
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println("처리 명령은 정수만 가능");
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
			
		}
	
	
	}
	
	public static void main(String[] args) {
		new ParkingLot().manage();
	}
	
	

}