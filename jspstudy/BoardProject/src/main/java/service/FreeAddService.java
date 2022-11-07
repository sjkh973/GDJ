package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDao;

public class FreeAddService implements FreeService{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String writer = request.getParameter("writer");
		String title =  request.getParameter("title");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		
		Free free = Free.builder()
				.writer(writer)
				.title(title)
				.content(content)
				.ip(ip)
				.build();
				
		
		int result = FreeDao.getInstance().insertFree(free);

		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('게시글이 등록되었습니다.')");
			out.println("location.href='" + request.getContextPath() + "/list.do'");
			out.println("</script>");
		} 
		out.close();
		
		return null;
	}

}
