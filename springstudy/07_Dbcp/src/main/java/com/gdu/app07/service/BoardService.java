package com.gdu.app07.service;

import java.util.List;

import com.gdu.app07.domain.BoardDTO;

public interface BoardService {
	// 서비스 계층의 이름은 "사용자 친화적으로" 작성
	public List<BoardDTO> findAllBoards();
	public BoardDTO findBoardByNo(int board_no);
	public int saveBoard(BoardDTO board);
	public int modifyBoard(BoardDTO board);
	public int removeBoard(int board_no);
	
}
