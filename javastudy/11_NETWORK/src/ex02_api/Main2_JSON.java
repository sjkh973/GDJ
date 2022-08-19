package ex02_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class Main2_JSON {
	
	
	public static void m1() {
			
		// 전국종량제봉투가격표준데이터

		
		// API 주소	(주소 + 요청 파라미터)
		String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
		
		try {
			
			String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==";
			apiURL += "?pageNo=" + URLEncoder.encode("0", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("100", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("json", "UTF-8");
			apiURL += "&CTPRVN_NM=" + URLEncoder.encode("인천광역시", "UTF-8");
			apiURL += "&SIGNGU_NM=" + URLEncoder.encode("계양구", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TYPE=" + URLEncoder.encode("규격봉투", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_MTHD=" + URLEncoder.encode("소각용", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_PRPOS=" + URLEncoder.encode("생활쓰레기", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TRGET=" + URLEncoder.encode("기타", "UTF-8");
			apiURL += "&serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			
		} catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
		
		// API 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 주소 접속 실패");
		}
		
		
		// 입력 스트림(응답) 생성
		// 1. 응답 성공 시 정상 스트림, 실패 시 에러 스트림
		// 2. 응답 데이터는 StringBuilder에 저장
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			// 스트림 종료
			reader.close();
			
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		
		// API로부터 전달받은 json 데이터
		String response = sb.toString();
		
		// JSON File 생성
		File file = new File("C:\\storage", "api1.json");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void m2() {
		
		// JSONObject 클래스 : {} , 객체를 의미
		// JSONArray 클래스 : [] , 배열을 의미
		
		File file = new File("C:\\storage", "api1.json");
		
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = null;
			while((line = br.readLine())!= null) {
				sb.append(line);
			}
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		// 전체 오브젝트 {response}
		// {Property:value}
		JSONObject obj = new JSONObject(sb.toString());
		JSONObject obj2 = obj.getJSONObject("response");
		JSONObject obj3 = obj2.getJSONObject("header");
		String resultCode = obj3.getString("resultCode");
		String resultMsg = obj3.getString("resultMsg");
		
		System.out.println(resultCode + ", " + resultMsg);
		
	}
	
	public static String m3() {
		
		StringBuilder urlbuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
		String serviceKey = "PKpeco/Pq5XH7mMz9HmJhE7hlMDEhqsUvfqfzzkveinRe0CK4b2k2MKYnMaKQ7z891xIneUpF6/a10IdAmpA6g==";		
		try {
			urlbuilder.append("?serviceKey=" + URLEncoder.encode(serviceKey,"UTF-8"));
			urlbuilder.append("&numOfRows=10");
			urlbuilder.append("&pageNo=1");
			urlbuilder.append("&dataType=json");
			urlbuilder.append("&base_date=20220819");
			urlbuilder.append("&base_time=0600");
			urlbuilder.append("&nx=58");
			urlbuilder.append("&ny=125");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//api 주소 접속
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(urlbuilder.toString());
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET"); //생략가능 생략하면 자동으로 get방식임
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//입력 스트림
		
		BufferedReader br =null;
		StringBuilder sb= new StringBuilder();
		
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br= new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			else {
				br= new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}		
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			//스트림 종료
			br.close();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		// API로부터 전달받은 json 데이터
		String response = sb.toString();
		
		// XML File 생성
		File file = new File("C:\\storage", "api2.json");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	public static void m4() {
		
		JSONObject obj = new JSONObject(m3());
		JSONObject response = obj.getJSONObject("response");
		JSONObject body = response.getJSONObject("body");
		JSONObject items = body.getJSONObject("items");
		JSONArray item = items.getJSONArray("item");
		for(int i = 0; i < item.length(); i++) {
			JSONObject element = item.getJSONObject(i); // item의 오브젝트하나{}를 element에 for문으로 대입
			System.out.println(element.getString("category") + ": " + element.getString("obsrValue")); // element의 스트링 타입의 요소 가져오기
			
		}
		
		
	}
	
	public static String m5() {
		
		StringBuilder urlbuilder = new StringBuilder("http://apis.data.go.kr/B553077/api/open/sdsc2/storeZoneOne");
		String serviceKey = "PKpeco/Pq5XH7mMz9HmJhE7hlMDEhqsUvfqfzzkveinRe0CK4b2k2MKYnMaKQ7z891xIneUpF6/a10IdAmpA6g==";		
		try {
			urlbuilder.append("?serviceKey=" + URLEncoder.encode(serviceKey,"UTF-8"));
			urlbuilder.append("&key=9940");
			urlbuilder.append("&type=json");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//api 주소 접속
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(urlbuilder.toString());
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET"); //생략가능 생략하면 자동으로 get방식임
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//입력 스트림
		
		BufferedReader br =null;
		StringBuilder sb= new StringBuilder();
		
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br= new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			else {
				br= new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}		
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			//스트림 종료
			br.close();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		// API로부터 전달받은 json 데이터
		String response = sb.toString();
		
		// XML File 생성
		File file = new File("C:\\storage", "api2.json");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	public static void m6() {
	
		JSONObject obj = new JSONObject(m5());
		JSONObject header = obj.getJSONObject("header");
		JSONArray columns = header.getJSONArray("columns");
		
		
		JSONObject body = obj.getJSONObject("body");
		JSONArray items = body.getJSONArray("items");
		JSONObject item = items.getJSONObject(0);
		//System.out.println(item.toString());
		
		String[] p = {"trarNo", "mainTrarNm", "ctprvnCd", "ctprvnNm", "signguCd", "signguNm", "trarArea", "coordNum", "coords", "stdrDt"};
		
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		for(int i = 0; i < columns.length(); i++) {
			map.put(columns.getString(i), item.get(p[i])); // map의 반환타입이 object이므로 굳이 getint, getstring으로 하지않고 get으로 해도됨
		}
		System.out.println(map);
		
		
	}
	
	public static String m7() {
		
		//기상청 RSS
		String urlBuilder = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5013061000";
		
		
		//api 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(urlBuilder);
			con = (HttpURLConnection)url.openConnection();
			//con.setRequestMethod("GET");
			//con.addRequestProperty("Content-Type", "application/xml; charset=UTF-8"); < = 생략가능
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//입력스트림
		BufferedReader br =null;
		StringBuilder sb = new StringBuilder();
		
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String line = null;
			
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			br.close();
		} catch (IOException e) {
			
			System.out.println("응답 실패");
		}
		
		// API로부터 전달받은 xml 데이터
		
		
		// XML File 생성
		File file = new File("C:\\storage", "api4.xml");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(sb.toString());
			bw.close();
		}catch (IOException e) {
			System.out.println("파일생성 실패");
		}
		
		return sb.toString();
	}
	
	public static void m8() {
		
		
		//XML 문서를 JSONObject로 변환
		JSONObject obj = XML.toJSONObject(m7());
		
		
		JSONArray dataList = obj.getJSONObject("rss")
								.getJSONObject("channel")
								.getJSONObject("item")
								.getJSONObject("description")
								.getJSONObject("body")
								.getJSONArray("data");
		
		for(int i = 0; i < dataList.length(); i++) {
			JSONObject weather = dataList.getJSONObject(i);
			System.out.println(weather.getInt("hour") + "시 :" + weather.getInt("temp") + "도, " + weather.getString("wfKor"));
		}
		
								
		
	}
	
	public static void main(String[] args) {
		m8();
	}

}
