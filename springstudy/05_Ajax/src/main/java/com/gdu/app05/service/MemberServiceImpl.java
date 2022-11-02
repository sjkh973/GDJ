package com.gdu.app05.service;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.app05.domain.Member;

public class MemberServiceImpl implements MemberService {

	@Override
	public String execute1(HttpServletRequest request, HttpServletResponse response) {
		String id = null;
		String pw = null;
		
		try {
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			if(id.isEmpty() || pw.isEmpty()) {
				throw new RuntimeException("아이디와 비밀번호를 모두 입력하세요.");
			}
			return "당신의 아이디는" + id + "이고, 패스워드는" + pw + "입니다.";
		}catch (Exception e) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println(e.getMessage());
				out.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
		
		
	}

	@Override
	public Member execute2(String id, String pw) {
		
		return new Member(id, pw);
	}

	@Override
	public Map<String, Object> execute3(Member member) {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("id", member.getId());
		map.put("pw", member.getPw());
		return map;
	}
	
	

}
