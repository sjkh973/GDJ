package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.StudentAddService;
import service.StudentDetailService;
import service.StudentFindService;
import service.StudentListService;
import service.StudentModifyService;
import service.StudentRemoveService;
import service.StudentService;


@WebServlet("*.do")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 / 응답 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 요청 확인
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = requestURI.substring(contextPath.length());
		
		// StudentService 객체
		StudentService service = null;
		
		// ActionForward 객체
		ActionForward af = null;
		
		// 요청에 따른 Service 선택
		switch (urlMapping) {
		case "/student/list.do":
			service = new StudentListService();
			break;
		case "/student/add.do" :
			service = new StudentAddService();
			break;
		case  "/student/find.do" : 
			service = new StudentFindService();
			break;
		case "/student/remove.do" : 
			service = new StudentRemoveService();
			break;
			
		case "/student/detail.do" :
			service = new StudentDetailService();
			break;
		case "/student/modify.do" : 
			service = new StudentModifyService();
			break;
			
		case "/student/write.do" : 
			af= new ActionForward();
			af.setView("/student/write.jsp");
			af.setRedirect(false);
			break;
		}
		
		// 선택된 Service 실행
		try {
			if(service != null) {
				af = service.execute(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// 어디로 어떻게 이동하는가?
	      if(af != null) {
	         if(af.isRedirect()) {
	            response.sendRedirect(af.getView());
	         } else {
	            request.getRequestDispatcher(af.getView()).forward(request, response);
	         }
	      }
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
