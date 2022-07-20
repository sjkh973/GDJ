package ex02_casting;

public class Ex03 {

	public static void main(String[] args) {
		
		/*
		 * 
		 */
		
		String strScore = "100";
		String strMoney = "10000000000";
		String strGrade = "4.5";
		
		//문자열을 정수타입으로 변경하는 코드 정수타입.parse정수타입("문자열");
		int score = Integer.parseInt(strScore); 
		long money = Long.parseLong(strMoney);  
		double grade = Double.parseDouble(strGrade);
		
		System.out.println(score);
		System.out.println(money);
		System.out.println(grade);
	
		//정수형을 문자형으로 변경 String.valueof(정수형);
		int age = 100;
		String strAge = String.valueOf(age);
		System.out.println(strAge);
			
		
		
		
		

	}

}
