package com.gdu.app10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app10.domain.BoardDTO;
import com.gdu.app10.mapper.BoardMapper;



@Service // 컴포넌트로 등록
public class BoardServiceImpl implements BoardService{

	// Service Dao는 사용합니다.
	//@Autowired   // 컨테이너의 생성된 bean 중에서 BoardDAO 타입의 Bean을 가져오시오. // 컨테이너에 있는것을 찾아서 집어 넣어줌
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<BoardDTO> findAllBoards() {	
		return mapper.selectAllBoards();
	}

	@Override
	public BoardDTO findBoardByNo(int boardNo) {	
		return mapper.selectBoardByNo(boardNo);
	}

	@Override
	public int saveBoard(BoardDTO board) {	
		return mapper.insertBoard(board);
	}

	@Override
	public int modifyBoard(BoardDTO board) {	
		return mapper.updateBoard(board);
	}

	@Override
	public int removeBoard(int boardNo) {	
		 return mapper.deleteBoard(boardNo);
	}
	
}
