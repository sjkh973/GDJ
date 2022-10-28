package com.gdu.app01.java03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("java03/appCtx.xml");

		Book book1 = ctx.getBean("book1", Book.class); // 메소드명이 문자열로 들어감    .getBeam(메소드명, 클래스);		
		System.out.println(book1.getTitle());
		System.out.println(book1.getAuthor());
		System.out.println(book1.getPublisher().getName());
		System.out.println(book1.getPublisher().getTel());
		
		Book book2 = ctx.getBean("book2", Book.class);	
		System.out.println(book2.getTitle());
		System.out.println(book2.getAuthor());
		System.out.println(book2.getPublisher().getName());
		System.out.println(book2.getPublisher().getTel());
		
		ctx.close();
	}

}
