package com.gdu.app12.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.gdu.app12.domain.BbsDTO;

public interface BbsService {

	public void findAllBbsList(HttpServletRequest request, Model model);
	public int addBbs(HttpServletRequest request);		// ip알아내기위해 request로 보냄
	public int addReply(HttpServletRequest request);
	public int removeBbs(int bbsNo);
}
