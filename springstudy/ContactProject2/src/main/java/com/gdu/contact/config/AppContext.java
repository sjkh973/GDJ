package com.gdu.contact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.contact.repository.ContactDAO;
import com.gdu.contact.service.ContactService;
import com.gdu.contact.service.ContactServiceImpl;


// 스프링 컨테이너에 Bean을 등록하기 위한 클래스
// Bean으로 등록시켜놓아야 @Autowired를 이용해서 가져갈 수 있습니다.


@Configuration
public class AppContext {

	@Bean
	public ContactDAO dao() {
		return new ContactDAO();
	}
	
	@Bean
	public ContactService contactService() {
		return new ContactServiceImpl();
	}
	
}
