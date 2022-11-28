package com.gdu.app15.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gdu.app15.domain.CommentDTO;

public interface CommentService {
	public Map<String, Object> getCommentCount(int blogNo);
	public Map<String, Object> addComment(CommentDTO comment);
	public Map<String, Object> getCommentList(HttpServletRequest request);
}
