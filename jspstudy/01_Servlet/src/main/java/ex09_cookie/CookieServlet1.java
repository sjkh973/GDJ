package ex09_cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet1")
public class CookieServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 쿠키
		// 1. 서버가 만들어서 클라이언트 PC에 저장해 두는 정보
		// 2. 응답할 때 쿠키를 저장함
		// 3. 클라이언트 요청이 있을 때 모든 쿠키 정보를 읽어 들일 수 있음
		
		// 쿠키 만들기
		// 1. 쿠키이름 : 알파벳, 숫자로 만듬
		// 2. 쿠키값   : 공백, 콜론, 세미콜론 등 불가한 문자가 있는 경우 인코딩해서 포함할 수 있음
		Cookie cookie1 = new Cookie("name", "김주성");
		Cookie cookie2 = new Cookie("address", URLEncoder.encode("서울시 금천구 가산동", "UTF-8"));
		
		// 쿠키 유효시간 설정 , 초단위
		cookie1.setMaxAge(60 * 60 * 24 * 15); // 15일
		cookie2.setMaxAge(10); // 10초
		
		// 클라이언트 PC에 쿠키 저장하기
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		// 리다이렉트
		response.sendRedirect("/01_Servlet/CookieServlet2");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
