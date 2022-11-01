package com.gdu.app05.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.domain.Board;
import com.gdu.app05.service.BoardService;

@Controller
public class MyController2 {

	@GetMapping("board")
	public String board() {
		return "board";  // board.jsp로 forward
	}
	
	// BoardServiceImpl의
	// execute1() 메소드 호출
	
	@Autowired
	private BoardService boardService;
	
	@ResponseBody  // ajax반환타입은 이걸 붙어야 함
	@GetMapping(value="board/detail1"
			   ,produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Board> detail1(HttpServletRequest request) {
		ResponseEntity<Board> board = boardService.execute1(request);
		return board;
	}
	
	@ResponseBody
	@GetMapping("board/detail2")
	public ResponseEntity<Board> detail2(@RequestParam(value="title") String title, @RequestParam(value="content") String content){
		
		return boardService.execute2(title, content);
	}
	
	@ResponseBody
	@GetMapping("board/detail3")
	public ResponseEntity<Board> detail3(Board board){
		
		return boardService.execute3(board);
	}
	
}
