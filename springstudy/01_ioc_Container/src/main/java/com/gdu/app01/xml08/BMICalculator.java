package com.gdu.app01.xml08;

public class BMICalculator {

	private Calculator calc;
	private double height; // 키
	private double weight;
	private double bmi;   // bmi : 몸무게 / 키 * 키
	private String health;
	
	public BMICalculator(Calculator calc, double height, double weight) {
		super();
		this.calc = calc;
		this.height = height;
		this.weight = weight;
		bmi = calc.div(weight, calc.div(calc.mul(height, height), 10000)); 
		health = (bmi < 20) ? "저체중" : (bmi < 25) ? "정상" : (bmi < 30) ? "과체중" : "비만";
	}
	
	// info() 메소드
	public void info() {
		System.out.println("BMI:" + bmi);
		System.out.println("Health: " + health);
	}
	
}
