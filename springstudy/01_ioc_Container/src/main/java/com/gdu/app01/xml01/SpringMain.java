package com.gdu.app01.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		// 기존 개발자
		// 개발자가 Bean을만들었다.
		//Calculator calculator = new Calculator();
		
		// 새로운 프레임워크
		// 프레임워크가 만든 Bean을 가져다 쓴다.
		
		// XML에 저장된 Bean 가져오는 클래스
		// GenericXmlApplicationContext
		// ClassPathXmlApplicationContext
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml01/appCtx.xml");
		Calculator calculator = ctx.getBean("calc", Calculator.class); // getBean() < - appCtx의 id를 가져옴
		calculator.add(5, 2);
		calculator.sub(5, 2);
		calculator.mul(5, 2);
		calculator.div(5, 2);
		
		System.out.println();
		
		Student student = ctx.getBean("haksang", Student.class);  //  Student student = (Student)ctx.getBean("haksang", Student.class);
		System.out.println(student.getName());
		System.out.println(student.getSchool());
		student.getCalculator().add(5, 2);
		student.getCalculator().sub(5, 2);
		student.getCalculator().mul(5, 2);
		student.getCalculator().div(5, 2);
		
		
		ctx.close(); // 생략 가능

	}

}
