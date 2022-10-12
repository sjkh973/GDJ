package ex06_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/JSONServlet")
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// 응답할 JSON 객체 만들기
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("age", age);
		
		// 응답
		response.setContentType("application/json; charset=UTF-8"); // JSON 데이터의 MIME-TYPE
		
		PrintWriter out = response.getWriter();	
		out.println(obj.toString());  // 응답 데이터는 텍스트 처리된 JSON 객체
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
