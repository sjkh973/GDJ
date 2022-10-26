package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import domain.Member;
import repository.MemberDao;

public class MemberServiceImpl implements MemberService {

	@Override
	public ActionForward login(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = Member.builder()
				.id(id)
				.pw(pw)
				.build();
		
		Member login = MemberDao.getInstance().login(member);
		
		if(login != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			return new ActionForward(request.getContextPath(), true); // 리다이렉트
		}else {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
	}

	@Override
	public ActionForward logout(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.invalidate(); // 세션 초기화
		
		return new ActionForward(request.getContextPath(), true);
	}

	@Override
	public void register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
