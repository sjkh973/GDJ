package com.gdu.rest.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.gdu.rest.domain.MemberDTO;

public interface MemberService {
	
	public Map<String, Object> register(MemberDTO member, HttpServletResponse response);
	public Map<String, Object> getMemberList(int page);
	public Map<String, Object> getMemberByNo(int memberNo);
}
