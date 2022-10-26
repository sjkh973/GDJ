package service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class NaverCaptchaServiceimpl implements NaverCaptchaService {

	// field
	
	private final String CLIENT_ID = "YY04Gb0Ya3y8WBXAuS8H";
	private final String CLIENT_SECRET = "1EQt8i7TLW";
	
	
	@Override
	public String getCaptcharKey() {
		// code=0 : "키 발급", code=1 : "사용자 입력값 검증"
			String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=0";
			
			// 반환할 key값(네이버API가 제공하는 캡차키)
			String key = null;
			
			try {

				// apiURL 접속
				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				
				// 요청 메소드(HTTP 메소드)
				con.setRequestMethod("GET");  // 대문자로 작성할 것
				
				// 요청 헤더 : 클라이언트 아이디, 클라이언트 시크릿
				con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
				con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
				
				// 입력 스트림 선택 및 생성(네이버 API서버의 정보를 읽기 위함)
				BufferedReader reader = null;
				if(con.getResponseCode() == 200) {  // 200 : HttpURLConnection.HTTP_OK
					reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else {
					reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
				
				// 네이버 API서버가 보낸 데이터 저장
				StringBuilder sb = new StringBuilder();
				String line;
				while((line = reader.readLine()) != null) {
					sb.append(line);
				}
				
				// 네이버 API서버가 보낸 데이터 확인 및 반환
				JSONObject obj = new JSONObject(sb.toString());
				key = obj.getString("key");
				
				// 자원 반납
				reader.close();
				con.disconnect();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return key;
		
	}

	@Override
	public Map<String, String> getCaptcharImage(HttpServletRequest request, String key) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
		// code = 0 : 키발급 code = 1 : 사용자 입력값 검증
						
			
			
			try {
				// 반환할 key값(네이버API가 제공하는 캡차키)
				// apiURL 접속
				
				//apiURL 접속
				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				
				// 요청 메소드(Http 메소드)
				con.setRequestMethod("GET"); // 대문자로 작성할 것
				
				//요청 헤더 : 클라이언트 아이디, 클라이언트 시크릿
				con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
				con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
				
				// 입력 스트림 선택 및 생성 (네이버 API서버의 정보를 읽기 위함)
				 
			
				// 응답이 성공하면 이미지(JPG)가 응답
				if(con.getResponseCode() == 200 ) { // 200 : HttpURLConnection.HTTP_OK
					// 캡차이미지  경로
					String dirname = "ncaptcha";
					String realPath = request.getServletContext().getRealPath(dirname);
					File dir = new File(realPath);
					if(dir.exists() == false) {
						dir.mkdirs();
					}
					
					
					// 이미지 이름
					String filename = System.currentTimeMillis() + ".jpg";
					// 캡차이미지 객체 생성
					File file = new File(dir, filename);
					// 네이버API로부터 정보를 읽어서(in) 서버경로에 저장(out)
					BufferedInputStream	in = new BufferedInputStream((con.getInputStream()));
					BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
					// 저장(다운로드)
					byte[] b = new byte[1024];
					int readByte = 0;
					while((readByte = in.read(b)) != -1) {
						out.write(b, 0, readByte);
					}
					//login.jsp로 전달할 데이터(캡차이미지 경로 + 파일명 +  캡차키)
					map.put("dirname", dirname);
					map.put("filename", filename);
					map.put("key", key);
					//자원 반납
					out.close();
					in.close();
				} 
				// 응답이 실패하면 텍스트 형식으로 응답
				else {
					// 응답이 실패하면 
					BufferedReader reader = new BufferedReader(new InputStreamReader(con.getErrorStream())); 
					StringBuilder sb = new StringBuilder();
					String line;
					while((line = reader.readLine()) != null) {
						sb.append(line);
					}
					System.out.println("<<응답 실패 사유>>");
					System.out.println(sb.toString());
					reader.close();
				}
				con.disconnect();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return map;
	}

	@Override
	public void refreshCaptcha(HttpServletRequest request, HttpServletResponse response) {
		
		// 응답 데이터형식 : JSON
		response.setContentType("application/json");
		
		// 응답 데이터
		/*
		 	{
		 		"dirname" : "ncapcha",
		 		"filename" : "1111111111111.jpg"
		 		"key" : "asdfdsagasdhgds"
		 	}
		 */
		// 캡차키 + 캡차이미지 새로 요청
		String key = getCaptcharKey();
		Map<String, String> map = getCaptcharImage(request, key);
		JSONObject obj = new JSONObject(map);
		
		// 응답
		
		try {
			PrintWriter out = response.getWriter();
			out.println(obj.toString());
			out.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean validateUserInput(HttpServletRequest request) {
		
		// 요청 파라미터(캡차키 + 사용자 입력값)
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		
		// 반환할 값
		boolean result = false;
		
		// apiURL
		String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=1&key=" + key + "&value=" + value;
		
		try {

			// apiURL 접속
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			// 요청 메소드(HTTP 메소드)
			con.setRequestMethod("GET");  // 대문자로 작성할 것
			
			// 요청 헤더 : 클라이언트 아이디, 클라이언트 시크릿
			con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
			con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
			
			// 입력 스트림 선택 및 생성(네이버 API서버의 정보를 읽기 위함)
			BufferedReader reader = null;
			if(con.getResponseCode() == 200) {  // 200 : HttpURLConnection.HTTP_OK
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			// 네이버 API서버가 보낸 데이터 저장
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			// 네이버 API서버가 보낸 데이터 확인 및 반환
			JSONObject obj = new JSONObject(sb.toString());
			result = obj.getBoolean("result");
			
			// 자원 반납
			reader.close();
			con.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	

	


}
