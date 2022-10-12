package ex08_binding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/BindingServlet")
public class BindingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// stateless
		// 1. 상태없음
		// 2. 웹 페이지 간 이동은 stateless
		// 3. 현재 페이지는 이전 페이지의 정보가 전혀 없음
		
		// Binding
		
		// 1. 속성(Attribute)에 정보를 저장하고 사용하는 것
		// 2. 3개 영역을 사용
		//	  	1) ServletContext     : 애플리케이션 내부 어디서든 접근해서 사용 가능
		//		2) HttpSession        : 브라우저 종료 전까지 접근해서 사용 가능 
		//		3) HttpServletRequest : 하나의 요청/응답 사이클 내에서 접근해서 사용가능
		// 3. 사용 메소드
		//		1) getAttribute('속성')     : 해당 속성 값 가져오기 (캐스팅이 필요할 수 있음)
		//		2) setAttribute('속성', 값) : 속성에 값 저장하기 (Object 타입으로 저장)
		//		3) removeAttribute('속성')  : 해당 속성 삭제하기
		
		// ServletContext
		ServletContext ctx = getServletContext(); // 또는 request.getServletContext();
		ctx.setAttribute("a", 1);
		
		// HttpSession
		HttpSession session = request.getSession();
		session.setAttribute("b", 2);
		
		// HttpServletRequest
		request.setAttribute("c", 3);
		
//		// 응답
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<a href=\"/01_Servlet/BindingServlet2\">이동</a>"); // 요청
//	
		
		//포워드
		// 1. request를 전달함
		// 2. 서버 내부 이동이므로 경로 작성 시 컨텍스트 패스는 작성하지 않음
		// request.getRequestDispatcher("/BindingServlet2").forward(request, response);
		
		// 리다이렉트
		// 1. request를 전달하지 않음
		// 2. 클라이언트 -> 서버로 이동하므로 컨텍스트패스를 작성해야 함
		response.sendRedirect("/01_Servlet/BindingServlet2");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
