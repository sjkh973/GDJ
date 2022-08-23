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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main1_XML {

	
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
	
	public static void m2() {
		
		// API 주소	(주소 + 요청 파라미터)
		//String apiURL = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson";
		
		StringBuilder urlbuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
		String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==";
		
		try {		
			urlbuilder.append("?ServiceKey=" + URLEncoder.encode(serviceKey,"UTF-8"));
			urlbuilder.append("&startCreateDt=" + URLEncoder.encode("20220808","UTF-8"));
			urlbuilder.append("&endCreateDt=" + URLEncoder.encode("20220812", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// API 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(urlbuilder.toString()); // MalformedURLException 필요
			con = (HttpURLConnection)url.openConnection(); // IOException 필요
			con.setRequestMethod("GET"); //생략가능 생략하면 자동으로 get방식임
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("API 주소 접속 실패");
		}
		
		// 입력 스트림(응답) 생성
		// 1. 응답 성공 시 정상 스트림, 실패 시 에러 스트림
		// 2. 응답 데이터는 StringBuilder에 저장
		
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}		
			
			String line = null;
			while((line = br.readLine())!= null) {
				sb.append(line + "\n" );
			}
			
			// 스트림 종료
			br.close();	
		}
		
		 catch (IOException e) {	
			e.printStackTrace();
		}
		
		// API로부터 전달받은 xml 데이터
		String response = sb.toString();
		
		// XML File 생성
		File file = new File("C:\\storage", "api2.xml");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void m3() {
		// xml 파싱
		
				File file2 = new File("C:\\storage", "api2.xml"); // api2가 document임
				
				try {
					//태그 한덩어리 <> </> 를 node 혹은 element라고 함
					
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();
					Document doc = builder.parse(file2); // 파일을 document(doc)이라고 함
					
					// api2.xml 문서의 최상위 태그 - > root라고 지정
					Element root = doc.getDocumentElement(); //  .getDocumentElement < = 태그의 정보를 가져와라
					
					//<item> ... </item> 태그 하나 == 특정 날짜의 데이터
					// 태그 이름("item")으로 root안에 있는 태그 찾기
					StringBuilder sb = new StringBuilder();
					NodeList items = root.getElementsByTagName("item");  // item안에 여러가지 데이터를 담을 NodeList배열리스트 선언
					for(int i = 0; i < items.getLength(); i++) {
						Node item = items.item(i); // nodelist에서 node하나 가져오는게 .item(index)메소드임
						//System.out.println(item.getNodeName()); //node하나의 이름 확인
						NodeList itemChildren = item.getChildNodes(); //item의 자식 노드들
						
						for(int j = 0; j < itemChildren.getLength(); j++) {				
							Node itemChild = itemChildren.item(j);
							if(itemChild.getNodeName().equals("stateDt")) { //노드의 이름이 stateDt면
								sb.append(" 날짜 : ").append(itemChild.getTextContent());
							}
							else if(itemChild.getNodeName().equals("decideCnt")){
								sb.append(" 확진자수 : ").append(itemChild.getTextContent());
							}
							else if(itemChild.getNodeName().equals("deathCnt")){
								sb.append("사망자수: ").append(itemChild.getTextContent());
							}
						}
						sb.append("\n");
						//Node stateDt = itemChildren.item(4); // 5번째 노드
						//System.out.println(stateDt.getNodeName()); //5번째 노드의 이름 확인
						// Node stateDt        == <stateDt>20220812</stateDt>
						//statedt.getNodeName() == stateDt (태그이름)
						//statedt.getTextContent() == 20220812 (태그내부 텍스트)			
					}
					System.out.println(sb.toString());
					
				}catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	public static void m4() {
		
		StringBuilder urlbuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
		String serviceKey = "PKpeco/Pq5XH7mMz9HmJhE7hlMDEhqsUvfqfzzkveinRe0CK4b2k2MKYnMaKQ7z891xIneUpF6/a10IdAmpA6g==";		
		try {
			urlbuilder.append("?serviceKey=" + URLEncoder.encode(serviceKey,"UTF-8"));
			urlbuilder.append("&numOfRows=10");
			urlbuilder.append("&pageNo=1");
			urlbuilder.append("&base_date=20220818");
			urlbuilder.append("&base_time=1100");
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
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
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
				sb.append(line + "\n");
			}
			
			//스트림 종료
			br.close();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		// API로부터 전달받은 xml 데이터
		String response = sb.toString();
		
		// XML File 생성
		File file = new File("C:\\storage", "api3.xml");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void m5() {
		
		
		// Node = 태그 , 줄바꿈 까지 포함
		// element = 태그 만
		// Document = 문서
		
		
		
		File file = new File("C:\\storage", "api3.xml");
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			NodeList items = root.getElementsByTagName("item");
			for(int i = 0; i < items.getLength(); i++) {
				/*
				 * Node item = items.item(i); NodeList itemChildren = item.getChildNodes();
				 * for(int j = 0; j <itemChildren.getLength(); j++) { Node itemChild =
				 * itemChildren.item(j); if(itemChild.getNodeName().equals("category")) {
				 * System.out.println("단기예보: " +itemChild.getTextContent()); }
				 * 
				 * } 
				 */
				Element item = (Element)items.item(i); //Node -> Element 타입으로 다운캐스팅	  
				Node category = item.getElementsByTagName("category").item(0); // element로 바꿔야 .getElementsByTagName("태그이름") 메소드 사용가능
				Node obsrValue = item.getElementsByTagName("obsrValue").item(0);
				String strCategory = null;
				switch (category.getTextContent()) {
				case "PTY" : strCategory = "강수형태"; break;
				case "REH" : strCategory = "습도"; break;
				case "RN1" : strCategory = "강수량(1시간)"; break;
				case "T1H" : strCategory = "기온"; break;
				case "UUU" : strCategory = "동서바람성분"; break;
				case "VEC" : strCategory = "풍향"; break;
				case "VVV" : strCategory = "남북바람성분"; break;
				case "WSD" : strCategory = "풍속"; break;
				}
				System.out.println(strCategory + " : " + obsrValue.getTextContent());
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		}
		
	public static void m6() {
		
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
				sb.append(line + "\n");
			}
			
			br.close();
		} catch (IOException e) {
			
			System.out.println("응답 실패");
		}
		
		// API로부터 전달받은 xml 데이터
		String response = sb.toString();
		
		// XML File 생성
		File file = new File("C:\\storage", "api4.xml");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		}catch (IOException e) {
			System.out.println("파일생성 실패");
		}
	}

	
	//M7다시해야댐
	public static void m7() {

		File file = new File("C:\\storage", "api4.xml");
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			StringBuilder sb = new StringBuilder();
			
			Node title = root.getElementsByTagName("title").item(0);
			sb.append(title.getTextContent()).append("\n");
			
			Node pubDate = root.getElementsByTagName("pubDate").item(0);
			sb.append(pubDate.getTextContent()).append("\n");
			
			NodeList dataList = root.getElementsByTagName("data");
			for(int i = 0; i < dataList.getLength(); i++) {
				Element data = (Element)dataList.item(i);
				Node hour = data.getElementsByTagName("hour").item(0);
				Node temp = data.getElementsByTagName("temp").item(0);
				Node wfKor = data.getElementsByTagName("wfKor").item(0);
				sb.append(hour.getTextContent()).append("시 ");
				sb.append(temp.getTextContent()).append("도 ");
				sb.append(wfKor.getTextContent()).append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void m8() {
		
		try {
			String apiURL = "https://www.kma.go.kr/XML/weather/sfc_web_map.xml";

			URL url = new URL(apiURL);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			//접속 확인 코드
			if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("API 접속 실패");
				return;
			}
				
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			File file = new File("C:\\storage", "sfc_web_map.xml");
	
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			// readLine() 메소드를 이용한 복사
			String line = null;			
			while((line = br.readLine()) != null) {
				bw.write(line + "\n");
			}
			
			//닫기
			bw.close();
			br.close();
			con.disconnect();
						
		}catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			e.getMessage();
			System.out.println("API 서버 오류");
		}
		
	}
	
	public static void m9() {
		
		File file = new File("C:\\storage", "sfc_web_map.xml");
		
		try {
			
			StringBuilder sb = new StringBuilder();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement(); //<current xmlns = "current"> 태그
			//System.out.println(root.getNodeName());
			//System.out.println(root.getAttribute("xmlns")); // .getAttribute(속성) = 속성값
			
			Element weather = (Element)root.getElementsByTagName("weather").item(0); // <weather year="2022" month="08" day="16" hour="09">
			sb.append(weather.getAttribute("year") + "년");
			sb.append(weather.getAttribute("month") + "월");
			sb.append(weather.getAttribute("day") + "일");
			sb.append(weather.getAttribute("hour") + "시\n");
			
			NodeList locals = root.getElementsByTagName("local");
			for(int i = 0; i < locals.getLength(); i++) {
				Element local = (Element)locals.item(i);
				sb.append(local.getTextContent() + "  : " ); //지역이름
				sb.append(local.getAttribute("ta") + "℃ " ); //지역이름
				sb.append(local.getAttribute("desc") + "\n" ); //지역이름			
			}
			System.out.println(sb.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		m7();
		
		
	}

}