package com.gdu.app09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app09.domain.BoardDTO;
import com.gdu.app09.service.BoardService;

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
		
		// Model의 Attribute는 Mock 테스트에서 getModelAndView()로 확인 가능하다.
		model.addAttribute("boards", boardService.findAllBoards());
	
		return "board/list";
		
	}
	
	
	@GetMapping("/brd/write")
	public String write() {
		return "board/write";
	}
	
	
	@PostMapping("/brd/add")
	public String add(BoardDTO board
			        , RedirectAttributes redirectAttributes) {
		
		// FlashAttribute는 Mock 테스트에서 getFlashMap()으로 확인 가능하다
		redirectAttributes.addFlashAttribute("insertResult", boardService.saveBoard(board));  
		
		return "redirect:/brd/list";  // FlashAttribute는 redirect할 때 데이터를 전달해 주므로 list.jsp에서 insertResult를 확인할 수 있다.
		
	}
	
	
	@GetMapping("/brd/detail")
	public String detail(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo
			           , Model model) {
		
		// Model의 Attribute는 Mock 테스트에서 getModelAndView()로 확인 가능하다.
		model.addAttribute("board", boardService.findBoardByNo(boardNo));
		
		return "board/detail";
		
	}
	
	
	@PostMapping("/brd/edit")
	public String edit(int boardNo
			         , Model model) {
		model.addAttribute("board", boardService.findBoardByNo(boardNo));
		return "board/edit";  // board 폴더의 edit.jsp로 forward 
	}
	
	
	@PostMapping("/brd/modify")
	public String modify(BoardDTO board
			           , RedirectAttributes redirectAttributes) {
		
		// FlashAttribute는 Mock 테스트에서 getFlashMap()으로 확인 가능하다
		redirectAttributes.addFlashAttribute("updateResult", boardService.modifyBoard(board));
		
		return "redirect:/brd/detail?boardNo=" + board.getBoardNo();  // FlashAttribute는 redirect할 때 데이터를 전달해 주므로 detail.jsp에서 updateResult를 확인할 수 있다.
		
	}
	
	
	@PostMapping("/brd/remove")
	public String remove(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo
	                   , RedirectAttributes redirectAttributes) {
		
		// FlashAttribute는 Mock 테스트에서 getFlashMap()으로 확인 가능하다
		redirectAttributes.addFlashAttribute("deleteResult", boardService.removeBoard(boardNo));
		
		return "redirect:/brd/list";  // FlashAttribute는 redirect할 때 데이터를 전달해 주므로 list.jsp에서 deleteResult를 확인할 수 있다.
		
	}
	
}
