package service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NaverCaptchaService {
	
	
	public String getCaptcharKey();
	public Map<String, String> getCaptcharImage(HttpServletRequest request, String key);
	public void refreshCaptcha(HttpServletRequest request, HttpServletResponse response);
	public boolean validateUserInput(HttpServletRequest request);
}
