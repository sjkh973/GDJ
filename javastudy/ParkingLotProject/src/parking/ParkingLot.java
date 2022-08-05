package parking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParkingLot {

	private String name; // 주차장이름
	private Car[] cars; //Car 인스턴스를 저장할 수 있는 배열
	private int idx; //배열의 인덱스;
	private Scanner sc; // 키보드 입력을 처리하는 인스턴스
	
	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
	public void addCar() throws RuntimeException {
		System.out.println("현재 등록된 차량" + idx + "대");
		if(idx == cars.length) {
			throw new RuntimeException("더 이상 차량 등록이 불가능합니다.");
		}
		System.out.print("차량번호>>>");
		String carNum = sc.nextLine();
		System.out.print("모델>>>");
		String modelName = sc.nextLine();
		Car car = new Car(carNum, modelName);
		cars[idx++] = car;
		System.out.println("차량번호 " + carNum + " 차량이 등록되었습니다." );
	}
	
	
	public void deleteCar() throws RuntimeException {
		if(idx == 0) {
			throw new RuntimeException("등록된 차량이 없습니다.");
		}
		System.out.print("제거할 차량번호>>>");
		String carNum = sc.nextLine();
		for(int i = 0; i < idx; i++) {
			if(carNum.equals(cars[i].getCarNo())) { // carNum.equals(cars[i])
				System.arraycopy (cars, (i + 1), cars, i, idx - (i - 1));
				cars[--idx] = null;
				System.out.println("차량번호" + carNum + "차량이 삭제되었습니다.");			
				return;
			}
		}
		System.out.println("대상 차량이 존재하지 않습니다");
	}
	
	public void printAllCars() throws RuntimeException {
		if(idx == 0) {
			throw new RuntimeException("조회할 차량이 없습니다.");
		}
		System.out.println(name + " 차량 목록");
		
		for(int i = 0; i < idx; i++) {
			System.out.println(cars[i]);
		}
		
	}
	
	public void manage() {
		
		while(true) {
			try {
				System.out.print("1.추가 2. 삭제 3. 전체 0. 종료>>>");
				int n = sc.nextInt();
				sc.nextLine();
				switch(n) {
				case 1 : addCar(); break;
				case 2 : deleteCar(); break;
				case 3 : printAllCars(); break;
				case 0 : System.out.println("주차관리 종료");return;
				default : System.out.println("존재하지 않는 메뉴입니다.");
				}	
			} catch (InputMismatchException e) {
				sc.next(); // 미스매치 입력인 문자열을 제거해줌
				System.out.println("처리 명령은 정수 (1 ~ 4,0)");
			} catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
}
