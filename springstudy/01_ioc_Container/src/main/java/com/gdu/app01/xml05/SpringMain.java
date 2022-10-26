package com.gdu.app01.xml05;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) throws Exception{
		

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml05/appCtx.xml");
		MyConnection myCon = ctx.getBean("conn", MyConnection.class);
		Connection con = myCon.getConnection();
		
		if(con != null) {
	         con.close();
	         System.out.println("Connection 해제 완료!");
	      }
		
		ctx.close();
		
	}

}
