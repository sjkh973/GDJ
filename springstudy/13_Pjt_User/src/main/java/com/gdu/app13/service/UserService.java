package com.gdu.app13.service;

import java.util.Map;

public interface UserService {

	public Map<String, Object> isReduceId(String id);
	public Map<String, Object> isReduceEmail(String email);
	public Map<String, Object> sendAuthCode(String email);
	
}
