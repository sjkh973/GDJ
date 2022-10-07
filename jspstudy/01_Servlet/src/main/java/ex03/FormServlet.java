package ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		// client.html에서 서브밋한 id 값을 저장
		request.setCharacterEncoding("UTF-8");
		
		// 변수(파라미터)
		String id = request.getParameter("id");
		if(id == null || id.isEmpty()) { // isEmpty() < - 비어있는값
			id = "빈아이디";
		}
		
		String pwd = request.getParameter("pwd");
		if(pwd.isEmpty()) {
			pwd = "빈 비밀번호";
		}
		
		String gender = request.getParameter("gender");
		if(gender == null) { // radio나 checkbox는 값이 없으면 null 이다.
			gender = "빈 성별";
		}
		String city = request.getParameter("city");
		if(city.isEmpty()) {
			city = "빈 도시";
		}
		
		// 배열(파라미터)
		String[] phone = request.getParameterValues("phone");
		if(phone[0].isEmpty()) {
			phone[0] = "빈 전화1";
		}
		if(phone[1].isEmpty()) {
			phone[1] = "빈 전화2";
		}
		if(phone[2].isEmpty()) {
			phone[2] = "빈 전화3";
		}
		
		String strPhone = phone[0] + "-" + phone[1] + "-" + phone[2];
		
		String[] agree = request.getParameterValues("agree");
		if(agree == null) {
			agree = new String[1];
			agree[0] = "빈 동의";
		}
		
		//연습(이메일)
		String emailId = request.getParameter("email_id");
		String domain = request.getParameter("domain");
		
		// 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>아이디: " + id + "</h3>");
		out.println("<h3>비밀번호:" + pwd + "</h3>");
		out.println("<h3>성별:" + gender + "</h3>");
		out.println("<h3>도시:" + city + "</h3>");
		out.println("<h3>연락처:" + strPhone + "</h3>");	
		out.println("<h3>동의여부:" + Arrays.toString(agree) + "</h3>");	
		out.println("<h3>이메일 :" + emailId + "@" + domain + "</h3>");
		List<String> list = Arrays.asList(agree);  // 문자열 배열 agree가 List로 변환됨
		if(list.contains("marketing")) {
			out.println("<h3>마케팅 동의한 회원</h3>");
		}
		out.close();	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
