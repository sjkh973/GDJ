package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDao;

public class FreeListService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FreeDao dao = FreeDao.getInstance();
		
		request.setAttribute("frees", dao.selectAllFree());
		
		return new ActionForward("/free/list.jsp", false);
	}

}
