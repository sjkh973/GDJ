package ex07_naver_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PapagoServlet")
public class PapagoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트 아이디, 시크릿
		String clientId = "YY04Gb0Ya3y8WBXAuS8H";
		String clientSecret = "1EQt8i7TLW";
		
		
		// 요청 파라미터(원본언어, 목적언어, 번역할텍스트)
		String source = request.getParameter("source"); //원본언어
		String target = request.getParameter("target"); //목적언어
		String text = request.getParameter("text"); // 번역할 텍스트
		
		// 번역할텍스트 UTF-8 인코딩
		try {
			text = URLEncoder.encode(text, "UTF-8");
		}catch (UnsupportedEncodingException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("번역할 텍스트 인코딩 실패");
			out.close();
		}
		
		// API 접속
		
		String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			
		}catch (MalformedURLException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API URL이 잘못되었습니다.");
			out.close();
		} catch (IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 연결이 실패했습니다.");
			out.close();
		}
		
		// API 요청
		try {
			// 요청 헤더
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			// 요청 메소드
			con.setRequestMethod("POST");
			con.setDoOutput(true); 	
			// 요청 파라미터 보내기 post방식이므로 url이 아닌 본문에 더해서 보내줘야 함
			String params = "source=" + source + "&target=" + target + "&text=" + text;
			OutputStream outputStream = con.getOutputStream(); // getOutputStream은 byte기반 스트림임 따라서 위의 String params를 바이트로 변환해줘야 함
			outputStream.write(params.getBytes());  // .getBytes()   < - String을 byte로 변환해주는 메소드
			outputStream.close();

		}catch (IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 요청이 실패했습니다.");
			out.close();
		}
		
		
		// API 응답 스트림 생성(정상 스트림, 에러 스트림)
		BufferedReader reader = null;
		
		try {
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
		}catch (IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 응답 스트림 생성이 실패했습니다.");
			out.close();
		}
		
		// API 응답
		StringBuilder sb = new StringBuilder();
		String line = null;
		
		try {	
			while((line = reader.readLine())!=null) {
				sb.append(line);
			}		
		}catch (IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 응답이 실패했습니다.");
			out.close();
		}
		
		// client.html로 API 응답 결과(StringBuilder) 보내기
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		System.out.println(sb.toString());
		out.close();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
