package com.gdu.app15.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app15.domain.CommentDTO;

@Mapper
public interface CommentMapper {
	public int selectCommentCount(int blogNo);
	public int insertComment(CommentDTO comment);	
	public List<CommentDTO> selectCommentList(Map<String, Object> map);
}
