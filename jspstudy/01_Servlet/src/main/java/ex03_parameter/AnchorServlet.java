package ex03_parameter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AnchorServlet")
public class AnchorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AnchorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 파라미터(Parameter) 확인
		
		
		String strA = request.getParameter("a");
		String strB = request.getParameter("b");
		
		// null 처리
			
			
		int a =0;
		int b= 0;
		if(strA !=null && strB != null) {
			a = Integer.parseInt(strA);
			b = Integer.parseInt(strB);
		}
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello World</h1>");
		int result = a + b;
		out.println("<h1>" + a + "+" + b + "=" +  result + "</h1>");
		
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
