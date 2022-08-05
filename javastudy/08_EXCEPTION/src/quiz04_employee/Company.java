package quiz04_employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Company {

	private Employee[] employees;
	private int idx;
	private Scanner sc;
	
	public Company() {
		employees = new Employee[5];
		sc = new Scanner(System.in);
	}
	
	public void addEmployee() throws EmployeeException {
		if(idx == employees.length) {
			throw new EmployeeException("Full", 1);  // 사원 가득참
		}
		System.out.print("고용 형태 선택(1.정규 2.비정규) >>> ");
		int kind = sc.nextInt();
		System.out.print("신규 사원번호 >>> ");
		int empNo = sc.nextInt();
		System.out.print("신규 사원명 >>> ");
		String name = sc.next();
		switch(kind) {
		case 1:
			System.out.print("기본급 >>> ");
			int salary = sc.nextInt();
			employees[idx++] = new Regular(empNo, name, salary);
			break;
		case 2:
			System.out.print("시급 >>> ");
			double hourPay = sc.nextDouble();
			System.out.print("근무시간 >>> ");
			int workTimes = sc.nextInt();
			Temporary temporary = new Temporary(empNo, name);
			temporary.setHourPay(hourPay);
			temporary.setWorkTimes(workTimes);
			employees[idx++] = temporary;
			break;
		default: throw new EmployeeException("Bad Request", 3);  // 잘못된 요청
		}
		System.out.println("사원 등록 완료. 현재 등록된 사원 " + idx + "명");
	}
	
	public void dropEmployee() throws EmployeeException {
		if(idx == 0) {
			throw new EmployeeException("Empty", 2);  // 사원 없음
		}
		System.out.print("삭제할 사원번호 >>> ");
		int empNo = sc.nextInt();
		for(int i = 0; i < idx; i++) {
			if(empNo == employees[i].getEmpNo()) {
				System.arraycopy(employees, i + 1, employees, i, idx - 1 - i);
				employees[--idx] = null;
				System.out.println("사원 삭제 완료. 현재 등록된 사원 " + idx + "명");
				return;
			}
		}
		throw new EmployeeException("Not Found", 4);  // 해당 사원 없음
	}
	
	public void findEmployee() throws EmployeeException {
		if(idx == 0) {
			throw new EmployeeException("Empty", 2);  // 사원 없음
		}
		System.out.print("조회할 사원번호 >>> ");
		int empNo = sc.nextInt();
		for(int i = 0; i < idx; i++) {
			if(empNo == employees[i].getEmpNo()) {
				System.out.println("사원 조회 완료. 조회된 사원 정보");
				System.out.println(employees[i]);
				return;
			}
		}
		throw new EmployeeException("Not Found", 4);  // 해당 사원 없음
	}
	
	public void printAllEmployees() throws EmployeeException {
		if(idx == 0) {
			throw new EmployeeException("Empty", 2);  // 사원 없음
		}
		int total = 0;
		System.out.println("전체 사원 목록(" + idx + "명)");
		for(int i = 0; i < idx; i++) {
			System.out.println(employees[i] + "[Pay : " + employees[i].getPay() + "]");
			total += employees[i].getPay();
		}
		System.out.println("Total salary " + total);
	}
	
	public void manage() {
		while(true) {
			try {
				System.out.print("1.추가 2.삭제 3.조회 4.목록 0.종료 >>> ");
				int choice = sc.nextInt();
				switch(choice) {
				case 1: addEmployee(); break;
				case 2: dropEmployee(); break;
				case 3: findEmployee(); break;
				case 4: printAllEmployees(); break;
				case 0: return;
				default: throw new EmployeeException("Bad Request", 3);  // 잘못된 요청
				}
			} catch(InputMismatchException e) {  // InputMismatchException -> EmployeeException으로 변경
				sc.next();
				try {
					throw new EmployeeException("Bad Request", 3);  // 잘못된 요청
				} catch(EmployeeException e2) {
					System.out.println(e2.getMessage() + "," + e2.getErrorCode());
				}
			} catch(EmployeeException e) {
				System.out.println(e.getMessage() + "," + e.getErrorCode());
			}
		}
	}
	
}