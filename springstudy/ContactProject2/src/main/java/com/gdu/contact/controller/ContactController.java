package com.gdu.contact.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.contact.service.ContactService;

@Controller
public class ContactController {

	
	// ContactController의 특징
	// 각 메소드는 서비스를 호출하는 이외의 일은 거의 하지 않는다.
	// 대부분의 비즈니스 처리는 서비스가 담당하고 있다.
	// 조회 처리는 매개변수로 model을 사용하고, 삽입/수정/삭제는 매개변수로 request/response를 사용한다.
	
	
	@Autowired
	private ContactService contactService;
	
	
	@GetMapping({"/", "card/list"})  // 2가지 이상의 매핑 처리 방법
	public String list(Model model) {
		contactService.findAllContacts(model);  // model에 목록을 저장할 수 있도록 서비스에게 model을 전달합니다.
		return "contact/list";
	}
	
	@GetMapping("card/write")
	public String write() {
		return "contact/write";
	}
	
	@PostMapping("card/register")
	public void register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 서비스에게 request와 response를 모두 전달하면 요청 파라미터와 응답 결과를 모두 처리할 수 있습니다. 
		contactService.register(request, response); 
	}
	
	@GetMapping("card/detail")
	public String detail(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); // model에 request를 저장해 두었다가 다시 꺼낼 수 있습니다.
		contactService.findContactByNo(model);  // model에 목록을 저장할 수 있도록 서비스에게 model을 전달합니다. 이 model에는 request도 저장되어 있습니다.
		return "contact/detail";
	}
	
	
	@PostMapping("card/modify")
	public void modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 서비스에게 request와 response를 모두 전달하면 요청 파라미터와 응답 결과를 모두 처리할 수 있습니다.
		contactService.modify(request, response);
	}
	
	
	@PostMapping("card/remove")
	public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 서비스에게 request와 response를 모두 전달하면 요청 파라미터와 응답 결과를 모두 처리할 수 있습니다.
		contactService.remove(request, response);
	}
	
}
