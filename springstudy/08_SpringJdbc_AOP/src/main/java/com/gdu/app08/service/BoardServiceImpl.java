package com.gdu.app08.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app08.domain.BoardDTO;
import com.gdu.app08.repository.BoardDAO;


@Service // 컴포넌트로 등록
public class BoardServiceImpl implements BoardService{

	// Service Dao는 사용합니다.
	//@Autowired   // 컨테이너의 생성된 bean 중에서 BoardDAO 타입의 Bean을 가져오시오. // 컨테이너에 있는것을 찾아서 집어 넣어줌
	
	@Autowired
	private BoardDAO dao;
	
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
	
	@Override
	public void testTransaction() {
		
		// 트랜잭션은 언제 필요한가요?
		// 하나의 서비스에서 2개 이상의 INSERT/UPDATE/DELETE가 호출되는 경우에 필요합니다.
		
		// 성공
		dao.insertBoard(new BoardDTO(0, "트랜잭션제목","트랜잭션내용", "트랜잭션작성자", null, null));
		// 실패
		dao.insertBoard(new BoardDTO()); // Exception이 발생하는 실패 상황 연출
		// 트랜잭션이 정상적으로 동작한다면,
		// 둘다 실패해야 한다.
		
	}
	
}
