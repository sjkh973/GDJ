package quiz04_employee;

public abstract class Employee {

	private int empNo; // 사번
	private String name; //이름
	
	public Employee(int empNo, String name) {
		super();
		this.empNo = empNo;
		this.name = name;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", name=" + name ;
	}
	
	public abstract int getPay();  // 모든 사원들의 월급을 반환하는 메소드. 정규/비정규에 따라 계산법이 다르기 때문에 추상메소드로 작성
}
