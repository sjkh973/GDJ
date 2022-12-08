package com.gdu.app01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app01.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/brd/list")
	public String list(Model model) {
		model.addAttribute("boards", boardService.findAllBoards());
		return "board/list";
	}
	
	@GetMapping("/brd/write")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/brd/add")
	public void add(HttpServletRequest request, HttpServletResponse response) {
		// saveBoard() 메소드에 list.jsp로 redirect하는 코드가 있기 때문에 return 없이 void 처리합니다.
		boardService.saveBoard(request, response);
	}	
	
	@GetMapping("/brd/detail")
	public String detail(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo
			           , Model model) {
		model.addAttribute("board", boardService.findBoardByNo(boardNo));
		return "board/detail"; 
	}
	
	@PostMapping("/brd/edit")
	public String edit(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo
			         , Model model) {
		model.addAttribute("board", boardService.findBoardByNo(boardNo));
		return "board/edit"; 
	}
	
	@PostMapping("/brd/modify")
	public void modify(HttpServletRequest request, HttpServletResponse response) {
		// modifyBoard() 메소드에 detail.jsp로 redirect하는 코드가 있기 때문에 return 없이 void 처리합니다.
		boardService.modifyBoard(request, response);
	}
	
	@PostMapping("/brd/remove")
	public void remove(HttpServletRequest request, HttpServletResponse response) {
		// removeBoard() 메소드에 list.jsp로 redirect하는 코드가 있기 때문에 return 없이 void 처리합니다.
		boardService.removeBoard(request, response);
	}
	
	@PostMapping("/brd/remove/list")
	public void removeList(HttpServletRequest request, HttpServletResponse response) {
		// removeBoardList() 메소드에 list.jsp로 redirect하는 코드가 있기 때문에 return 없이 void 처리합니다.
		boardService.removeBoardList(request, response);
	}
	
}