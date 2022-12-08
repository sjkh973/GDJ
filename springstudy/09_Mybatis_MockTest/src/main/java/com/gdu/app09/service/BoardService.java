package com.gdu.app09.service;

import java.util.List;

import com.gdu.app09.domain.BoardDTO;

public interface BoardService {
	public List<BoardDTO> findAllBoards();
	public BoardDTO findBoardByNo(int boardNo);
	public int saveBoard(BoardDTO board);
	public int modifyBoard(BoardDTO board);
	public int removeBoard(int boardNo);
}
