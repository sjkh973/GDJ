package com.gdu.app09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app09.domain.BoardDTO;
import com.gdu.app09.repository.BoardDAO;

@Service  // 컴포넌트로 등록
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;

	@Override
	public List<BoardDTO> findAllBoards() {
		return dao.selectAllBoards();
	}

	@Override
	public BoardDTO findBoardByNo(int boardNo) {
		return dao.selectBoardByNo(boardNo);
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
	public int removeBoard(int boardNo) {
		return dao.deleteBoard(boardNo);
	}
	
}
