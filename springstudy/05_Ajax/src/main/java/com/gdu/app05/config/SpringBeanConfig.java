package com.gdu.app05.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app05.service.BoardService;
import com.gdu.app05.service.BoardServiceImpl;
import com.gdu.app05.service.ContactService;
import com.gdu.app05.service.ContactServiceImpl;
import com.gdu.app05.service.GalleryService;
import com.gdu.app05.service.GalleryServiceImpl;
import com.gdu.app05.service.MemberService;
import com.gdu.app05.service.MemberServiceImpl;
import com.gdu.app05.service.MovieService;
import com.gdu.app05.service.MovieServiceImpl;

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
	
	@Bean
	public ContactService contactService() {
		ContactService service = new ContactServiceImpl();
		return service;
	}
	
	@Bean
	public GalleryService galleryService() {
		return new GalleryServiceImpl();
	}
}
