package ex02_lambda.sec03;

public class Soil {

	private int totalOil = 1000;
	private int payPerLiter = 2000;
	private int earning;
	
	// 2. 메소드의 지역변수에 익명 객체 저장하기
	public void sellOil() {
		
		// 지역변수
		/*Car car = new Car() {
			
			@Override
			public void addOil() {
				int oil = 20;
				totalOil -= oil;
				earning += oil * payPerLiter;
				System.out.println("감사합니다 벤츠");
				
			}
		}; 
		*/
		Car car = () ->{
			int oil = 20;
			totalOil -= oil;
			earning += oil * payPerLiter;
			System.out.println("감사합니다 벤츠");
		};
		
		// 지역변수는 메소드를 벗어나면 소멸되므로 메소드 내부에서 호출해야 함
		car.addOil();
		
	} 
		
		

	public int getTotalOil() {
		return totalOil;
	}

	public void setTotalOil(int totalOil) {
		this.totalOil = totalOil;
	}

	public int getPayPerLiter() {
		return payPerLiter;
	}

	public void setPayPerLiter(int payPerLiter) {
		this.payPerLiter = payPerLiter;
	}

	public int getEarning() {
		return earning;
	}

	public void setEarning(int earning) {
		this.earning = earning;
	}


	
	
	
}
