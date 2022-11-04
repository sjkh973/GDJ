package com.gdu.app07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app07.repository.BoardDAO;
import com.gdu.app07.service.BoardService;
import com.gdu.app07.service.BoardServiceImpl;

@Configuration
public class BoardAppContext {
	
	// 06_Jdbc의 @Repository 대신 추가한 Bean
	@Bean
	public BoardDAO dao() {
		return new BoardDAO();
	}
	
	// 06_Jdbc의 @Service 대신 추가한 Bean
	@Bean
	public BoardService service() {
		return new BoardServiceImpl(dao());
	}
}
