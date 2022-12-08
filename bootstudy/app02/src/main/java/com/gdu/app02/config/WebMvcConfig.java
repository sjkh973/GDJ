package com.gdu.app02.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// 서블릿 컨텍스트의 리소스를 자바 클래스로 바꿀때 WebMvcConfigurer인터페이스를 가져옴
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/load/image/**")
			.addResourceLocations("file:///C:/summbernoteImage/");
		
	}
	
}
