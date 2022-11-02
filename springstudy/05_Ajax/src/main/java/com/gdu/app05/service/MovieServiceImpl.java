package com.gdu.app05.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MovieServiceImpl implements MovieService {

   @Override
   public String getBoxOffice(String targetDt) {
      
      String key = "6f47c633ed30dcf44921a526b96a966d";
      String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=" + key + "&targetDt=" + targetDt;
      
      // API 요청
      URL url = null;
      HttpURLConnection con = null;
      
      try {
         url = new URL(apiURL); // MalformedURLException 발생가능 
         con = (HttpURLConnection)url.openConnection();	// IOException 발생가능
         con.setRequestMethod("GET"); // GET을 대문자로 지정
         //con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      }catch (MalformedURLException e) {
         e.printStackTrace();
      }catch (IOException e) {
		e.printStackTrace();
      }
      
      // API 응답
      
     
      StringBuilder sb = new StringBuilder();
      
      
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))){  // try - catch-resources문은 자원의 close를 생략할수 있다
    	  String line = null;
    	  while((line = reader.readLine())!= null) {
    		  sb.append(line);
    	  }
      } catch (Exception e) {
		e.printStackTrace();
	  }
      
      // con 닫기
      con.disconnect();
      
      System.out.println(sb.toString());
      // 반ㅎ헌 (API로부터 가져온 모든 텍스트 정보)
      return sb.toString();
      
      
      
   }

}