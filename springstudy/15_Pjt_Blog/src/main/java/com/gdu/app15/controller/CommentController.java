package com.gdu.app15.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app15.domain.CommentDTO;
import com.gdu.app15.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@ResponseBody
	@GetMapping(value="/comment/getCount", produces = "application/json")
	public Map<String, Object> getCount(@RequestParam("blogNo") int blogNo){
		return commentService.getCommentCount(blogNo);
	}
	
	@ResponseBody
	@PostMapping(value="/comment/add", produces = "application/json")
	public Map<String, Object> add(CommentDTO comment){
		return commentService.addComment(comment);
	}
	
	@ResponseBody
	@GetMapping(value="/comment/list", produces = "application/json")
	public Map<String, Object> list(HttpServletRequest request){
		return commentService.getCommentList(request);
	}

	@ResponseBody
	@PostMapping(value="/comment/remove", produces = "application/json")
	public Map<String, Object> remove(@RequestParam("commentNo") int commentNo){
		return commentService.removeComment(commentNo);
	}
	
	@ResponseBody
	@PostMapping(value="/comment/reply/add", produces = "application/json")
	public Map<String, Object> addReply(CommentDTO reply){
		return commentService.addReply(reply);
	}
	
}
