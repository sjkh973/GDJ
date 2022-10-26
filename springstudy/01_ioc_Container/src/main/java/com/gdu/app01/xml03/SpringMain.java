package com.gdu.app01.xml03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("xml3/appCtx.xml");
		Person person = ctx.getBean("person", Person.class);
		
		System.out.println(person.getAge());
		System.out.println(person.getName());
		System.out.println(person.getAddr().getJibun());
		System.out.println(person.getAddr().getRoad());
		System.out.println(person.getAddr().getZipCode());
		
		ctx.close();

	}

}
