package com.gdu.app01.service;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app01.domain.BoardDTO;
import com.gdu.app01.mapper.BoardMapper;

@Service  // 컴포넌트로 등록
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardDTO> findAllBoards() {
		return boardMapper.selectAllBoards();
	}

	@Override
	public BoardDTO findBoardByNo(int boardNo) {
		return boardMapper.selectBoardByNo(boardNo);
	}

	@Override
	public void saveBoard(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDTO board = new BoardDTO();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		
		int result = boardMapper.insertBoard(board);
		
		try {
			
			// 자바스크립트로 응답으로 만들어서 처리하는 방식
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			if(result > 0) {
				out.println("alert('삽입 성공');");
				out.println("location.href='" + request.getContextPath() + "/brd/list'");  //  /brd/list로 redirect
			} else {
				out.println("alert('삽입 실패');");
				out.println("history.back();");  // 이전 화면으로 이동
			}
			out.println("</script>");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifyBoard(HttpServletRequest request, HttpServletResponse response) {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo")); 
		
		BoardDTO board = new BoardDTO();
		board.setBoardNo(boardNo);
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		int result = boardMapper.updateBoard(board);
		
		try {
			
			// 자바스크립트로 응답으로 만들어서 처리하는 방식
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			if(result > 0) {
				out.println("alert('수정 성공');");
				out.println("location.href='" + request.getContextPath() + "/brd/detail?boardNo=" + boardNo + "';");  //  /brd/detail로 redirect
			} else {
				out.println("alert('수정 실패');");
				out.println("history.back();");  // 이전 화면으로 이동
			}
			out.println("</script>");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeBoard(HttpServletRequest request, HttpServletResponse response) {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo")); 
		
		int result = boardMapper.deleteBoard(boardNo);
		
		try {
			
			// 자바스크립트로 응답으로 만들어서 처리하는 방식
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			if(result > 0) {
				out.println("alert('삭제 성공');");
				out.println("location.href='" + request.getContextPath() + "/brd/list';");  //  /brd/list로 redirect
			} else {
				out.println("alert('삭제 실패');");
				out.println("history.back();");  // 이전 화면으로 이동
			}
			out.println("</script>");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void removeBoardList(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터
		String[] boardNoList = request.getParameterValues("boardNoList");
		
		// 삭제
		int result = boardMapper.deleteBoardList(Arrays.asList(boardNoList));  // String 배열을 List<String>으로 변경해서 전달
		
		try {
			
			// 자바스크립트로 응답으로 만들어서 처리하는 방식
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			if(result > 0) {
				out.println("alert('모두 삭제 성공');");
				out.println("location.href='" + request.getContextPath() + "/brd/list';");  //  /brd/list로 redirect
			} else {
				out.println("alert('모두 삭제 실패');");
				out.println("history.back();");  // 이전 화면으로 이동
			}
			out.println("</script>");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}