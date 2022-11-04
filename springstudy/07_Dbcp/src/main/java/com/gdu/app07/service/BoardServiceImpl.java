package com.gdu.app07.service;

import java.util.List;

import com.gdu.app07.domain.BoardDTO;
import com.gdu.app07.repository.BoardDAO;


/*
	@Service
	안녕. 난 Service에서 추가하는 @Component야.
	servlet-context.xml에 등록된 <context:component-scan> 태그에 의해서 bean으로 검색되지
	root-context.xml이나 @Configuration에 @Bean으로 등록하지 않아도 컨테이너에 만들어 져.
*/


//@Service // Service가 사용하는 @Component
//@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	// Service Dao는 사용합니다.
	//@Autowired   // 컨테이너의 생성된 bean 중에서 BoardDAO 타입의 Bean을 가져오시오. // 컨테이너에 있는것을 찾아서 집어 넣어줌
	
	private BoardDAO dao;
	
	// 생성자의 매개변수 BoardDAO dao로 new BoardDAO()가 주입되고 있다.
	// BoardAppContext.java를 참고
	public BoardServiceImpl(BoardDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<BoardDTO> findAllBoards() {	
		return dao.selectAllBoards();
	}

	@Override
	public BoardDTO findBoardByNo(int board_no) {	
		return dao.selectBoardByNo(board_no);
	}

	@Override
	public int saveBoard(BoardDTO board) {	
		return dao.insertBoard(board);
	}

	@Override
	public int modifyBoard(BoardDTO board) {	
		return dao.updateBoard(board);
	}

	@Override
	public int removeBoard(int board_no) {	
		 return dao.deleteBoard(board_no);
	}
	

}
