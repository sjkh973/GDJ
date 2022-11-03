package com.gdu.app07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.app07.domain.ContactDTO;
import com.gdu.app07.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("contacts", contactService.findAllContact());
		return "index";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("contacts", contactService.findAllContact());
		return "index";
	}
	
	@GetMapping("contact/write")
	public String write() {
		return "contact/write";
	}
	
	@PostMapping("contact/insert")
	public String insert(ContactDTO contact) {
		contactService.addContact(contact);
		return "redirect:/list";
	}
	 
}
