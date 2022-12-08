package com.gdu.app01.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.app01.domain.BoardDTO;

public interface BoardService {
	public List<BoardDTO> findAllBoards();
	public BoardDTO findBoardByNo(int boardNo);
	public void saveBoard(HttpServletRequest request, HttpServletResponse response);
	public void modifyBoard(HttpServletRequest request, HttpServletResponse response);
	public void removeBoard(HttpServletRequest request, HttpServletResponse response);
	public void removeBoardList(HttpServletRequest request, HttpServletResponse response);
}