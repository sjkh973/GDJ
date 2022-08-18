package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String key = "6f47c633ed30dcf44921a526b96a966d";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜(yyyymmdd)>>> ");
		String targetDt = sc.next();
		
		try {
			key = URLEncoder.encode(key,"UTF-8");
			targetDt = URLEncoder.encode(targetDt,"UTF-8");
			
		}catch (UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		}
		
		
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=" +key + "&targetDt=" + targetDt; 
		
		String response = getResponse(apiURL);
		createFile(response);
	}
	
	public static String getResponse(String apiURL) {
		
		HttpURLConnection con = getConnection(apiURL);
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				return readBody(con.getInputStream()); //매개변수는 InputStream 타입 readBody() 메소드는 String으로 반환되어야 함
			} else {
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청오류",e);
		}
	}
	
	public static HttpURLConnection getConnection(String apiURL) {
		
		try {
			URL url = new URL(apiURL);
			return (HttpURLConnection)url.openConnection();
		}catch (MalformedURLException e) {
			throw new RuntimeException("API 주소오류", e);
		}catch (IOException e) {
			throw new RuntimeException("API 연결오류", e);
		}
	}
	
	public static String readBody(InputStream in) {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			return sb.toString();
		}catch (IOException e) {
			throw new RuntimeException("API 응답 오류", e);
			
		}
	}
	
	public static void createFile(String response) {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\storage\\boxoffice.xml"));
			bw.write(response);
			bw.flush(); // 스트림에서 혹시 남은게 있다면 없앰 생략가능
		} catch (IOException e) {
			throw new RuntimeException("파일 생성오류",e);
		}
		
	}

}
