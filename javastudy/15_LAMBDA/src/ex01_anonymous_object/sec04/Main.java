package ex01_anonymous_object.sec04;

public class Main {

	public static void main(String[] args) {
		
		Soil soil = new Soil();
		
		soil.sellOil(new Car() {
			
			@Override
			public void addOil() {
				int oil = 30;
				soil.setTotalOil(soil.getTotalOil() - oil);
				soil.setEarning(soil.getEarning() + oil * soil.getPayPerLiter());
				System.out.println("감사합니다 BMW");
			}
		});
		
		soil.sellOil(new Car() {
			
			@Override
			public void addOil() {
				int oil = 30;
				soil.setTotalOil(soil.getTotalOil() - oil);
				soil.setEarning(soil.getEarning() + oil * soil.getPayPerLiter());
				System.out.println("감사합니다 BMW");
			}
		});
		
		soil.sellOil(new Car() {
			
			@Override
			public void addOil() {
				int oil = 30;
				soil.setTotalOil(soil.getTotalOil() - oil);
				soil.setEarning(soil.getEarning() + oil * soil.getPayPerLiter());
				System.out.println("감사합니다 BMW");
			}
		});
		
		System.out.println(soil.getTotalOil());
		System.out.println(soil.getEarning());
		

	}

}
