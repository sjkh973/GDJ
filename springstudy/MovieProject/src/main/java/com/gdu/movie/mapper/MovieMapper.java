package com.gdu.movie.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.movie.domain.MovieDTO;

@Mapper
public interface MovieMapper {
	
	public List<MovieDTO> selectAllMovies();
	public List<MovieDTO> selectMoviesByQuery(Map<String, Object> map);
	public int selectAllMoviesCount();
}
