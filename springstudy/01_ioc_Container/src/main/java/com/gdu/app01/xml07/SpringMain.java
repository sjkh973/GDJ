package com.gdu.app01.xml07;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml07/appCtx.xml");
		User user = ctx.getBean("user", User.class);
		user.info();
		ctx.close();

	}

}
