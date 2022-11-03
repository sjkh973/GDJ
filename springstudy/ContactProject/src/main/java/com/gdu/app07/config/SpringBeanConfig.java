package com.gdu.app07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app07.repository.ContactDAO;
import com.gdu.app07.service.ContactService;
import com.gdu.app07.service.ContactServiceImpl;


@Configuration
public class SpringBeanConfig {

	@Bean
	public ContactService contactService() {
		ContactService service = new ContactServiceImpl();
		return service;
	}
	@Bean
	public ContactDAO boardDao() {
		return new ContactDAO();
	}
	
}
