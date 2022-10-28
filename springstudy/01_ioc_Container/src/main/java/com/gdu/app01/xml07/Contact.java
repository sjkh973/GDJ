package com.gdu.app01.xml07;

public class Contact {

	private String address;
	private String email;
	private String tel;
	
	//constructor
	public Contact(String address, String email, String tel) {
		super();
		this.address = address;
		this.email = email;
		this.tel = tel;
	}
	
	//method
	public void info() {
		System.out.println("주소: " + address);
		System.out.println("이메일: " + email);
		System.out.println("연락처: " + tel);
	}
	
}
