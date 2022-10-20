package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDao;

public class BoardRemoveService implements BoardService{

	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		Optional<String> opt = Optional.ofNullable(request.getParameter("boardNo"));
		int boardNo = Integer.parseInt(opt.orElse("0"));
		
		// DB로 boardNo 보내기(삭제)
		int result = BoardDao.getInstance().deleteBoard(boardNo);
		
		// 삭제 성공 / 실패
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('게시글이 삭제되었습니다.')");
			out.println("location.href='" + request.getContextPath() + "/board/list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('게시글 삭제가 실패했습니다.')");
			out.println("history.back()");  // history.go(-1)
			out.println("</script>");
		}
		out.close();
		
		return null;  // 컨트롤러로 null을 반환하면 컨트롤러는 리다이렉트&포워드 모두 수행하지 않음

	}
	
}
