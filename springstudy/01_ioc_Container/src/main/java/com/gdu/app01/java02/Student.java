package com.gdu.app01.java02;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {

	private List<Integer> scores; 			// 0 ~ 100 사이의 랜덤 정수 5개
    private Set<String> awards;				// 임의의 상장 3개
    private Map<String, String> contact; 	// 연락처(address, tel)
    
	public List<Integer> getScores() {
		return scores;
	}
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	public Set<String> getAwards() {
		return awards;
	}
	public void setAwards(Set<String> awards) {
		this.awards = awards;
	}
	public Map<String, String> getContact() {
		return contact;
	}
	public void setContact(Map<String, String> contact) {
		this.contact = contact;
	}
    
	
    
}
