package com.gdu.app11.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface EmpService {

	// Request, Response, Session, Model을 최초로 선언할 수 있는곳은 컨트롤러임
	
	// 서비스의 모델 선언은 받아오기 위한 매개변수 임
	public void findAllEmployees(HttpServletRequest request, Model model); 
	public void findEmployees(HttpServletRequest request, Model model); 
	public Map<String, Object> findAutoCompleteList(HttpServletRequest request);
}
