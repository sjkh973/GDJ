package com.gdu.app01.xml06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml06/appCtx.xml");
		Person p = ctx.getBean("human", Person.class);
		p.info();
		ctx.close();
	}

}
