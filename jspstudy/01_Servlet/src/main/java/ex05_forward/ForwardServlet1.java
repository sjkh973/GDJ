package ex05_forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ForwardServlet1")
public class ForwardServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Forward
		// request에 데이터를 실어서 이동할 수 있음
		// 곧바로 응답하는게 아닌 servlet2에 전송시켜주고 응답 
		// 서버 내부에서 이동하는 방식이기 때문에 클라이언트는 URL 을 통해서 forward 한 경로를 확인할 수 없음(servlet2에 주소가 안보임)
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ForwardServlet2");
		requestDispatcher.forward(request, response); // request와 response를 그대로 넘겨준다.
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
