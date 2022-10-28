package com.gdu.app01.xml06;

import java.util.List;
import java.util.Map;
import java.util.Set;

// Collection Framework(List, Set, Map)에 주입

public class Person {

	// field
	private List<String> hobbies;
	private Set<String> contacts;
	private Map<String, String> friends;
	
	// method
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public Set<String> getContacts() {
		return contacts;
	}
	public void setContacts(Set<String> contacts) {
		this.contacts = contacts;
	}
	public Map<String, String> getFriends() {
		return friends;
	}
	public void setFriends(Map<String, String> friends) {
		this.friends = friends;
	}
	
	// info() 메소드
	public void info() {
		// List
		for(int i = 0; i < hobbies.size(); i++) {
			System.out.println((i + 1) + "번째 취미 : " + hobbies.get(i));
		}
		
		// Set (인덱스 없음)
		for(String contact : contacts) {
			System.out.println(contact);
		}
		// Map (Key + Value ==> Entry)
		for(Map.Entry<String, String> entry : friends.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
	
}
	
	
	
