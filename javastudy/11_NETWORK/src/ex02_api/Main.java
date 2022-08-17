package ex02_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	
	// 요청
	// 1. Request
	// 2. 클라이언트 -> 서버
	
	// 파라미터
	// 1. Parameter
	// 2. 보내는 데이터(변수 개념)
	
	// 응답
	// 1. Response
	// 2. 서버 -> 클라이언트

	
	public static void m1() {
		
		
		// 전국종량제봉투가격표준데이터

		
		// API 주소	(주소 + 요청 파라미터)
		String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
		
		try {
			
			String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==";
			apiURL += "?pageNo=" + URLEncoder.encode("0", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("100", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("xml", "UTF-8");
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
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
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
				sb.append(line + "\n");
			}
			
			// 스트림 종료
			reader.close();
			
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		
		// API로부터 전달받은 xml 데이터
		String response = sb.toString();
		
		// XML File 생성
		File file = new File("C:\\storage", "api1.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// xml 분석
		try {
		
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();   // <response> (최상위 태그)
			System.out.println(root.getNodeName());
			
			NodeList nodeList = root.getChildNodes();  // <response>의 자식 태그(<header>, <body>)
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);          // <header>와 <body>
				System.out.println("  " + node.getNodeName());
				NodeList nodeList2 = node.getChildNodes();        // <header>의 자식 태그(<resultCode>, <resultMsg>), <body>의 자식 태그(<items>, <numOfRows>, <pageNo>, <totalCount>)
				for(int j = 0; j < nodeList2.getLength(); j++) {
					Node node2 = nodeList2.item(j);
					System.out.println("    " + node2.getNodeName());
					if(node2.getNodeName().equals("items")) {     // <items> 태그 대상
						NodeList items = node2.getChildNodes();   // <items>의 자식 태그(<item>)
						for(int k = 0; k < items.getLength(); k++) {
							Node item = items.item(k);
							System.out.println("      " + item.getNodeName());
							NodeList itemChildren = item.getChildNodes();        // <item>의 자식 태그
							for(int l = 0; l < itemChildren.getLength(); l++) {
								Node itemChild = itemChildren.item(l);
								System.out.println("        " + itemChild.getNodeName() + ":" + itemChild.getTextContent());
							}
						}
					}
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 접속 종료
		con.disconnect();
		
	}
	
	public static void main(String[] args) {
		m1();
	}

}