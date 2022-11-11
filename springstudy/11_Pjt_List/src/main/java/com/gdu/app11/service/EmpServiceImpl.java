package com.gdu.app11.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app11.domain.EmpDTO;
import com.gdu.app11.mapper.EmpMapper;
import com.gdu.app11.util.PageUtil;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpMapper empMapper;
	
	@Autowired
	private PageUtil pageUtil;
	
	@Override
	public void findAllEmployees(HttpServletRequest request, Model model) {
		
		// request에서 page 파라미터 꺼내기
		// page 파라미터가 전달되지 않는 경우 page = 1로 처리한다.
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		// 전체 레코드(직원) 개수 구하기
		int totalRecord = empMapper.selectAllEmployeesCount();
		
		// PageUtil 계산하기
		pageUtil.setPageUtil(page, totalRecord);
	
		// Map 만들기(begin, end)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
		// begin~end 목록 가져오기
		List<EmpDTO> employees = empMapper.selectEmployeesByPage(map);
		
		// 뷰로 보낼 데이터
		model.addAttribute("employees", employees);
		model.addAttribute("paging", pageUtil.getPaging(request.getContextPath() + "/emp/list"));
		model.addAttribute("beginNo", totalRecord - (page - 1) * pageUtil.getRecordPerPage());

	}

	@Override
	public void findEmployees(HttpServletRequest request, Model model) {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		String column = request.getParameter("column");
		String query = request.getParameter("query");
		String start = request.getParameter("start");
		String stop = request.getParameter("stop");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", column);
		map.put("query", query);
		map.put("start", start);
		map.put("stop", stop);
		
		int totalRecord = empMapper.selectFindEmployeesCount(map);
		
		pageUtil.setPageUtil(page, totalRecord);
		
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
		List<EmpDTO> employees = empMapper.selectFindEmployees(map);
		
		model.addAttribute("employees", employees);
		model.addAttribute("beginNo", totalRecord - (page - 1) * pageUtil.getRecordPerPage());
		
		String path = null;
		switch(column) {
		case "EMPLOYEE_ID":
		case "E.DEPARTMENT_ID":
		case "LAST_NAME":
		case "FIRST_NAME":
		case "PHONE_NUMBER":
			path = request.getContextPath() + "/emp/search?column=" + column + "&query=" + query;
			break;
		case "HIRE_DATE":
		case "SALARY":
			path = request.getContextPath() + "/emp/search?column=" + column + "&start=" + start + "&stop=" + stop;
			break;
		}
		model.addAttribute("paging", pageUtil.getPaging(path));
		
	}
	
	@Override
	public Map<String, Object> findAutoCompleteList(HttpServletRequest request) {
		
		String target = request.getParameter("target");
		String param = request.getParameter("param");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("target", target);
		map.put("param", param);
		
		List<EmpDTO> list = empMapper.selectAutoCompleteList(map);
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(list.size() == 0) {
			result.put("status", 400);
			result.put("list", null);
		} else {
			result.put("status", 200);
			result.put("list", list);
		}
		
		switch(target) {
		case "FIRST_NAME": result.put("target", "firstName"); break;
		case "LAST_NAME": result.put("target", "lastName"); break;
		case "EMAIL": result.put("target", "email"); break;
		}
		return result;
		
		/* 
		 	Map<> result가 jackson에 의해서 아래 JSON으로 자동 변경된다.
		 	result = {
		 		"status" : 200,					 = > result.status  / result("status")
		 		"list" : [
		 			{
		 				"employeeId" : null,
		 				"firstName"  : null,
		 				"lastName"   : null,
		 				
		 				"email"      : "MHARTSTE"  = >  result.list[0].email
		 			},
		 			{
		 				...
		 			},
		 			...
		 		]
		 	}
		 */
		
	}

	
}