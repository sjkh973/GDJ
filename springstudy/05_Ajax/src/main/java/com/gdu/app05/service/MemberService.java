package com.gdu.app05.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.app05.domain.Member;

public interface MemberService {

	// 요청 파라미터
	public String execute1(HttpServletRequest request, HttpServletResponse response);
	public Member execute2(String id, String pw);
	public Map<String, Object> execute3(Member member);
	
	// 요청 JSON
	public Member execute4(Member member);
}
