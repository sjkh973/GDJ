package com.gdu.app08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app08.domain.BoardDTO;
import com.gdu.app08.service.BoardService;

import lombok.AllArgsConstructor;

// 필드를 이용한 생성자를 만들어 두면,
// 생성자의 매개변수로 컨테이너의 Bean이 자동 주입(@Autowired)되므로
// 필드에 @Autowired 처리할 필요가 없다.
@AllArgsConstructor

@Controller
public class BoardController {

	// Controller는 Service를 사용합니다.
	// @Autowired // 컨테이너에 생성된 bean 중에서 BoardService 타입의 bean을 가져오시오.
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
	
	@GetMapping("brd/write")
	public String write() {
		return "board/write";	// board 폴더의 write.jsp로 forward
	}
	
	@PostMapping("brd/add")
	public String add(BoardDTO board) {
		 boardService.saveBoard(board); // saveBoard()로부터 0/1이 반환되지만 처리하지 않았다.
		 return "redirect:/brd/list";
	}
	
	@GetMapping("brd/detail")
	public String detail(@RequestParam(value="board_no", required=false, defaultValue ="0") int board_no
						, Model model) { 
		model.addAttribute("board", boardService.findBoardByNo(board_no));
		return "board/detail";
	}
	
	@PostMapping("brd/edit")
	public String edit(int board_no, Model model) {
		model.addAttribute("board", boardService.findBoardByNo(board_no));
		return "board/edit"; // board 폴더의 edit.jsp로 forward
	}
	
	@PostMapping("brd/modify")
	public String modify(BoardDTO board) { // modifyBoard()로부터 0/1이 반환되지만 처리하지 않았다.
		boardService.modifyBoard(board);
		return "redirect:/brd/detail?board_no=" + board.getBoard_no();
	}
	
	@PostMapping("brd/remove")
	public String remove(int board_no, Model model) {
		boardService.removeBoard(board_no); // removeBoard()로부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/brd/list";
	}
	
	// 트랜잭션 확인을 위해서 testTransaction() 메소드를 호출하는 매핑
	@GetMapping("brd/transaction")
	public String transaction() {
		boardService.testTransaction();
		return "redirect:/brd/list";
	}
}
