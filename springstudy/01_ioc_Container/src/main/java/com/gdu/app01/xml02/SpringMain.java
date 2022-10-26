package com.gdu.app01.xml02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("xml2/appCtx.xml");
		Car myCar = ctx.getBean("dreamCar", Car.class);
		
		System.out.println(myCar.getModel());
		System.out.println(myCar.getMaker());
		
		Engine engine = myCar.getEngine();
		System.out.println(engine.getFuel());
		System.out.println(engine.getEfficency());
		System.out.println(engine.getCc());
		
		
		ctx.close();
	}

}
