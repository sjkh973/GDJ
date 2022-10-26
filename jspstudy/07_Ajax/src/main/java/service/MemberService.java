package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	
	// ajax는 화면이동이 없는 통신, 따라서 redirect, forward를 하지 않는다. 
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
