package com.gdu.app05.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app05.service.BoardService;
import com.gdu.app05.service.BoardServiceImpl;
import com.gdu.app05.service.MemberService;
import com.gdu.app05.service.MemberServiceImpl;

@Configuration
public class SpringBeanConfig {

	@Bean
	public MemberService memberService() {
		MemberService service = new MemberServiceImpl(); 
		return service;
	}
	
	@Bean
	public BoardService boardService() {
		BoardService service = new BoardServiceImpl();
		return service;
	}
}
