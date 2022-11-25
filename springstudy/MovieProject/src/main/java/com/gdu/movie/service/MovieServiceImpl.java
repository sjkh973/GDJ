package com.gdu.movie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.mapper.MovieMapper;
import com.gdu.movie.util.SecurityUtil;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	
	@Autowired
	private SecurityUtil securityUtil;
	
	@Override
	public List<MovieDTO> getMovieList() {
		
		return movieMapper.selectAllMovies();
	}
	
	@Override
	public Map<String, Object> findMovieList(HttpServletRequest request) {

		String column = request.getParameter("column");
		String searchText = request.getParameter("searchText");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", column);
		map.put("searchText",securityUtil.preventXSS(searchText));
		
		List<MovieDTO> list = movieMapper.selectMoviesByQuery(map);

		Map<String, Object> result = new HashMap<String, Object>();
		
		if(list.size() == 0) {
			result.put("status", 500);
			result.put("list", null);
		} else {
			result.put("status", 200);
			result.put("list", list);
		}

		
		switch(column) {
		case "TITLE": result.put("column", "title"); break;
		case "GENRE": result.put("column", "genre"); break;
		case "DESCRIPTION": result.put("column", "description"); break;
		}
		return result;
	}
	
}
