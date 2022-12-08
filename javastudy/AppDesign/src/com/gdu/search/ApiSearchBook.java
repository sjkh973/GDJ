package com.gdu.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiSearchBook {

	public static void main(String[] args) {
		
		String clientId="n9YYWxJmIYloswNOo_qK";
		String clientSecret="V13oyXP65F";
		
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("검색어를 입력하세요 >>>"  );
			String searchName = sc.next();
			sc.nextLine();
			String apiURL = "https://openapi.naver.com/v1/search/book?query=" + URLEncoder.encode(searchName,"UTF-8");
			sc.close();
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			BufferedReader br = null;
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			StringBuilder sb= new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			con.disconnect();
			
			//System.out.println(sb.toString());
			
			JSONObject obj = new JSONObject(sb.toString());
			JSONArray items = obj.getJSONArray("items");
			
			File dir = new File("C:/download");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			File file = new File(dir, searchName + ".html" );
			PrintWriter out = new PrintWriter(file);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"?UTF-8\">");
			out.println("<title>검색결과</title>");
			out.println("</head>");
			out.println("<body>");
			
			// 결과물
			
			for(int i = 0; i < items.length(); i++) {
				JSONObject element = items.getJSONObject(i);
				String title = element.getString("title");
				String link = element.getString("link");
				String image = element.getString("image");
				
				out.println("<img src=\""+ image + "\" width=\"150px\"><br>");
				out.println("<a href="+ link +">" + title + "</a>");
				
				
				out.println("<hr>");
			}
			out.println("</body>");
			out.println("</html>");
			out.close();
			
			
		} catch (Exception e) {
			
			try {
				
				File dir = new File("C:/download/log");
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				File file = new File(dir, "error_log.txt");
				PrintWriter out = new PrintWriter(file);
			    LocalDateTime now = LocalDateTime.now();
		        String date = now.format(DateTimeFormatter.ofPattern("yyyy-M-dd a h:mm:ss"));
	            out.println("예외메시지" + e.getMessage());
	            out.println("예외발생시간" + date);
	            out.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
