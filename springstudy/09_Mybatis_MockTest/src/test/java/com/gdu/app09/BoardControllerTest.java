package com.gdu.app09;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/*
	Mock 테스트

	가상 MVC 테스트를 의미한다.
	마치 브라우저를 사용하는 것처럼 테스트하기 때문에 Controller를 테스트 할 수 있는 통합 테스트이다.
*/


// JUnit4
@RunWith(SpringJUnit4ClassRunner.class)


// ServletContext 사용을 위해서 추가한 애너테이션, 
@WebAppConfiguration


// 필요한 Bean은 @Component로 등록되어 있으므로 component-scan 태그가 작성된 servlet-context.xml의 위치를 작성함
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class BoardControllerTest {

	
	// 로거
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardControllerTest.class);
	
	
	// @WebAppConfiguration이 있어야 @Autowired 가능
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	
	// webApplicationContext에 의해서 build() 되어 만들어 짐
	private MockMvc mockMvc;
	
	
	@Before  // 모든 @Test 수행 이전에 실행되므로 항상 mockMvc는 생성된 상태로 테스트가 진행된다.
	public void setup() {
		this.mockMvc = MockMvcBuilders
				.webAppContextSetup(webApplicationContext)
				.build();
	}

	
	@Test
	public void 목록테스트() throws Exception {
		LOGGER.debug(mockMvc.perform(MockMvcRequestBuilders.get("/brd/list"))  // get 방식의 "/brd/list" 호출 테스트
			.andReturn()            // 응답 결과에서
			.getModelAndView()      // ModelAndView를 가져와서 (Model을 가져오기 위함)
			.getModelMap()          // Model을 Map으로 바꾼 뒤
			.toString());           // 로그로 찍어보자.
	}
	
	
	@Test
	public void 등록테스트() throws Exception {
		LOGGER.debug(mockMvc.perform(MockMvcRequestBuilders.post("/brd/add")
				.param("title", "테스트 제목")      // 등록할 파라미터
				.param("writer", "테스트 작성자")
				.param("content", "테스트 내용"))
				.andReturn()
				.getFlashMap()  // RedirectAttributes를 이용해 FlashAttribute로 저장해 놓은 insertResult 확인을 위함
				.toString());
	}
	
	
	@Test
	public void 조회테스트() throws Exception {
		LOGGER.debug(mockMvc.perform(MockMvcRequestBuilders.get("/brd/detail")
				.param("boardNo", "1"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				.toString());

	}
	
	
	@Test
	public void 수정테스트() throws Exception {
		LOGGER.debug(mockMvc.perform(MockMvcRequestBuilders.post("/brd/modify")
				.param("title", "수정 테스트 제목")
				.param("content", "수정 테스트 내용")
				.param("boardNo", "1"))                // boardNo=1인 게시글을 수정함
				.andReturn()
				.getFlashMap()  // RedirectAttributes를 이용해 FlashAttribute로 저장해 놓은 updateResult 확인을 위함
				.toString());
	}
	
	
	@Test
	public void 삭제테스트() throws Exception {
		LOGGER.debug(mockMvc.perform(MockMvcRequestBuilders.post("/brd/remove")
				.param("boardNo", "1"))                // boardNo=1인 게시글을 삭제함
				.andReturn()
				.getFlashMap()  // RedirectAttributes를 이용해 FlashAttribute로 저장해 놓은 deleteResult 확인을 위함
				.toString());
	}
	
	
}
