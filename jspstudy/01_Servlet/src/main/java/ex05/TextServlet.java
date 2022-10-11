package ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TextServlet")
public class TextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			
			
			// 요청
			request.setCharacterEncoding("UTF-8");
			
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age")); // age가 null 또는 int가 아닐 때 NumberFormatException 발생 지점
			if(age < 0 || age > 100) {
				// 예외를 만들고자 할때 RuntimeException을 사용
				throw new RuntimeException(age + "살은 불가능한 나이입니다.");
			}
			
			response.setContentType("text/plain; charset=UTF-8"); // 단순 텍스트의 MIME-TYPE
			
			PrintWriter out = response.getWriter();
			
			out.println("이름은 " + name + "이고, 나이는" + age + "살입니다.");
			out.close();
		} catch (NumberFormatException e) {
			
			// 예외 처리 응답
			response.setContentType("text/plain; charset=UTF-8");
			
			response.setStatus(1000); // 개발자가 임의로 작성한 응답코드
			
			PrintWriter out = response.getWriter();
			out.println("예외 발생 ! 파라미터 age는 정수입니다."); // 개발자가 임의로 작성한 responseText
			out.close();
			
		} catch (RuntimeException e) {
			response.setContentType("text/plain; charset=UTF-8");
			
			response.setStatus(2000); // 개발자가 임의로 작성한 응답코드
			
			PrintWriter out = response.getWriter();
			out.println(e.getMessage()); // RuntimeException이 예외 객체에 저장된 예외 메시지를 responseText로 처리
			out.close();
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
