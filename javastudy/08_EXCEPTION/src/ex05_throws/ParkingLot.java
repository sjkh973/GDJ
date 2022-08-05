package ex05_throws;

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
	
	public void addCar() throws RuntimeException {
		if(idx == cars.length) {
			throw new RuntimeException("FULL");
		}	
	}
	
		
		
	
	
	public void deleteCar()throws RuntimeException {
		if(idx == 0) {
			throw new RuntimeException("EMPTY");
		}
		
		
	
		
	}
	
	public void findCar() throws RuntimeException{
		
	}

	public void printAllCar()throws RuntimeException {
	
	}
	
	public void manage()  {
		
		//각각의 메소드에서 throws를받아서 try-catch가 있는 메소드 manage에서 처리한다
		
			
			while(true) {
				try {
				System.out.println("1. 추가 2. 제거 3. 조회 4. 전체목록 0.종료");
				int choice = sc.nextInt();
				switch(choice) {
				case 1: addCar(); break;
				case 2: deleteCar(); break;
				case 3: findCar();break;
				case 4: printAllCar(); break;
				case 0: return;
				default : throw new RuntimeException("Bad Request");
				}	
				
				}catch (InputMismatchException e) {
					sc.next(); // 미스매치 입력인 문자열을 제거해줌
					System.out.println("처리 명령은 정수 (1 ~ 4,0)");
				} catch(RuntimeException e) {
					System.out.println(e.getMessage());
				}
			}	
	}
	
	public static void main(String[] args) {
		new ParkingLot().manage();
	
		
	}
}
