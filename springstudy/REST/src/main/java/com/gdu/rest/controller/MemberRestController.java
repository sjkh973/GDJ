package com.gdu.rest.controller;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.rest.domain.MemberDTO;
import com.gdu.rest.service.MemberService;

/*
  	REST : Representational State Transfer
  
  	1. 자원을 정의하고 자원의 주소를 지정하는 방식에 대한 하나의 형식이다.
  	2. REST 방식을 따르는 시스템을 "RESTful하다" 라고 표현한다.
  	3. 동작의 결정을 URL + Method 조합으로 결정한다.
  	4. 파라미터가 URL에 경로처럼 포함된다.(?를 사용하지 않는다.)
  	5. CRUD 처리 방식
  			     URL        Method
  		1) 삽입	 /members   POST
  		2) 목록  /members   GET
  		3) 상세  /members/1 GET
  		4) 수정  /members   PUT
 */

@RestController // 이 컨트롤러는 모든 메소드에 @ResponseBody 애너테이션을 추가한다.
public class MemberRestController {

	@Autowired // @service 애너테이션을 붙였기때문에 autowired 가능
	private MemberService memberService;
	
	// 삽입
	@PostMapping(value="/members", produces="application/json")
	public Map<String, Object> addMember(@RequestBody MemberDTO member, HttpServletResponse response){ // @RequestBody가 붙어야 jsp본문에서 member를 가져옴
		return memberService.register(member, response);

	}

	// 목록
	@GetMapping(value="/members/page/{page}", produces="application/json")
	public Map<String, Object> getMemberList(@PathVariable(value="page", required=false) Optional<String> opt){
		int page = Integer.parseInt(opt.orElse("1"));
		return memberService.getMemberList(page);
	}
	
	@GetMapping(value="/members/{memberNo}", produces = "application/json")
	public Map<String, Object> getmember(@PathVariable(value="memberNo", required = false) Optional<String> opt){
		int memberNo = Integer.parseInt(opt.orElse("0"));
		return memberService.getMemberByNo(memberNo);
	}
	
}
