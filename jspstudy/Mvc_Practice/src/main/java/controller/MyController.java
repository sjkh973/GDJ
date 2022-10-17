package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.CircleService;
import service.MyService;
import service.RectangleService;
import service.TriangleService;



@WebServlet("*.do")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 & 응답
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 요청 확인
		String requestURI = request.getRequestURI(); 	// requestURI  : /03_MVC/circle.do 또는 /03_MVC/polygon.do
		String contextPath = request.getContextPath();	// contextPath : /03_MVC
		String command = requestURI.substring(contextPath.length() +1); // command =   : circle.do 또는 polygon.do를 담아준다.
	
		// MyService 선언(모든 Model은 MyService 타입이다.)
		MyService myService = null;
		
		// 1. ActionForward 선언(모든 Model의 execute() 메소드의 반환타입은 ActionForward이다!)
		// 2. Model이 필요 없는 경우 ActionForward를 직접 만든다.
		ActionForward actionForward = null;
	
		// 요청에 따른 Model의 선택
		switch(command) {
		// 비즈니스 로직이 필요한 경우
		case "circle.do"  : 
			myService = new CircleService();
			break;
		case "triangle.do" :
			myService = new TriangleService();
			break;
		case "rectangle.do" :
			myService = new RectangleService();
			break;
		case "input.do" : 
			actionForward = new ActionForward();
			actionForward.setView("views/input.jsp");
			break;
		
		}
		if(myService != null) {
			actionForward = myService.execute(request, response);
		}
		
		if(actionForward != null) {
			if(actionForward.isRedirect()) { //actionForward가 true이면
				response.sendRedirect(actionForward.getView()); //리다이렉트
			} else {
				request.getRequestDispatcher(actionForward.getView()).forward(request, response);
			}
		}
		
		
		}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
