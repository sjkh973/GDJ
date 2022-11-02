package com.gdu.app06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.app06.service.BoardService;

@Controller
public class BoardController {

	// Controller는 Service를 사용합니다.
	@Autowired // 컨테이너에 생성된 bean 중에서 BoardService 타입의 bean을 가져오시오.
	private BoardService boardService;
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("brd/list")
	public String list(Model model) {  // Model은 forward할 속성(Attribute)을 저장할 때 사용한다.
		model.addAttribute("boards", boardService.findAllBoards());
		return "board/list";  // board 폴더의 list.jsp로 forward
	}
}
