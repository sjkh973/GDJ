package com.gdu.app11.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app11.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("emp/list")
	public String list(HttpServletRequest request, Model model) {
		empService.findAllEmployees(request, model);
		return "employee/list";
	}
	
	@GetMapping("emp/search")
	public String search(HttpServletRequest request, Model model) {
		empService.findEmployees(request, model);	
		return "employee/list";
	}
	
	@ResponseBody
	@GetMapping(value="emp/autoComplete", produces="application/json")
	public Map<String, Object> autoComplete(HttpServletRequest request){
		return empService.findAutoCompleteList(request);
	}
	
}
