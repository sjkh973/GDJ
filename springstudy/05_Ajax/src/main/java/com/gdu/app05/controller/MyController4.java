package com.gdu.app05.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.domain.Contact;
import com.gdu.app05.service.ContactService;

@Controller
public class MyController4 {

	
	@GetMapping("contact")
	public String contact() {
		return "contact";
	}
	
	
	// field
	@Autowired  // Container(SpringBeanConfig 클래스)에 등록된 bean 가져오기
	private ContactService contactService;
	
	
	/*
		@RequestBody
		안녕. 난 요청 데이터가 body에 포함되어 있다고 알려주는 일을 해.
		요청 파라미터에서는 사용할 수 없고,
		post 방식으로 파라미터 없이 데이터가 전달될 때 사용할 수 있어.
	*/
	
	
	@ResponseBody
	@PostMapping(value="contact/detail1"
	           , produces=MediaType.APPLICATION_JSON_VALUE)
	public Contact detail1(@RequestBody Contact contact) {  // post 방식으로 넘어온 JSON을 bean에 저장할 수 있다.
		return contactService.execute1(contact);
	}
	
	
	@ResponseBody
	@PostMapping(value="contact/detail2"
	           , produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> detail2(@RequestBody Map<String, Object> map) {  // post 방식으로 넘어온 JSON을 Map에 저장할 수 있다.
		return contactService.execute2(map);
	}
	
	
}