package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.BoardDetailService;
import service.BoardInsertService;
import service.BoardListService;
import service.BoardModifyService;
import service.BoardRemoveService;
import service.BoardService;


@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = requestURI.substring(contextPath.length());
		
		BoardService service = null;
		
		ActionForward af = null;
		
		switch (urlMapping) {
		case "/board/list.do" : 
			service = new BoardListService();
			break;
		case "/board/insert.do" : 
			service = new BoardInsertService();
			break;
		case "/board/detail.do" : 
			service = new BoardDetailService();
			break;			
		case "/board/modify.do" : 
			service = new BoardModifyService();
			break;
		case "/board/remove.do" : 
			service = new BoardRemoveService();
			break;
			
		case "/board/insertPage.do" : 
			af = new ActionForward("/board/insertPage.jsp", false);
			break;
		}
		
		try {
			if(service != null) {
				af = service.execute(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(af != null) {
			if(af.isRedirect()) {
				response.sendRedirect(af.getView());
			}else {
				request.getRequestDispatcher(af.getView()).forward(request, response);
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
