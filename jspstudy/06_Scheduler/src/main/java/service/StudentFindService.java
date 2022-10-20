package service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.StudentDao;

public class StudentFindService implements StudentService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		double begin = Double.parseDouble(request.getParameter("begin"));
		double end = Double.parseDouble(request.getParameter("end"));
		
		// DB로 보낼 Map 생성
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("begin", begin);
		map.put("end", end);
		
		StudentDao dao = StudentDao.getInstance();
		
		// request에 필요한 정보 저장하기
		request.setAttribute("students", dao.selectStudentByAve(map));
		request.setAttribute("count", dao.selectStudentByAveCount(map));
		request.setAttribute("average", dao.selectStudentByAveAverage(map));
		
		
		return new ActionForward("/student/list.jsp", false);
	}

}
