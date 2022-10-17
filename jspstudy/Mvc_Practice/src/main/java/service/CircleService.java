package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class CircleService implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 요청 파라미터
		int radius = Integer.parseInt(request.getParameter("radius"));	
		double CircleArea = Math.PI * Math.pow(radius, 2);
		
		request.setAttribute("radius", radius);
		request.setAttribute("area", CircleArea);
		request.setAttribute("shape", "circle");
		
		// 어디로 갈 것인가?(응답 Jsp 명시)
		// 어떻게 갈 것인가?(리다이렉트 또는 포워드)
		
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/output.jsp");
		actionForward.setRedirect(false);
		return actionForward;
	}

}
