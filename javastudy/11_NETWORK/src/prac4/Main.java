package prac4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void m1() {
		
		//API 주소
		String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4128165000";
		
		//API 주소 접속
		
		HttpURLConnection con = null;
		try {
			URL url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//입력 스트림
		
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			//입력받은 스트림을 한줄씩 읽을 변수선언
			
			String line = null;
			while((line = br.readLine()) !=null) {
				sb.append(line);
			}
			
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		String response = sb.toString();
		
		// XML File 생성
					File file = new File("C:\\storage", "prac4.xml");
					
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(file));
						bw.write(response);
						bw.close();
					}catch (IOException e) {
						System.out.println("파일생성 실패");
					}
		
	}
	
		
	
	public static void m2() {
		
		File file = new File("C:\\storage", "prac4.xml");
		
		
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			NodeList items = root.getElementsByTagName("channel");
			for(int i = 0; i < items.getLength(); i++) {
				Element item = (Element)items.item(i);
				StringBuilder sb = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				Node title = item.getElementsByTagName("title").item(0);
				sb.append(title.getTextContent() + "\n");
				Node pubDate = item.getElementsByTagName("pubDate").item(0);
				sb.append(pubDate.getTextContent() + "\n");
				
				NodeList data = item.getElementsByTagName("data");
				for(int j = 0; j < data.getLength(); j++) {		
					Node datas = data.item(i);
					
					System.out.println(datas.getNodeName());
				
				}
				
				System.out.println(sb.toString() + sb2.toString());
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
				
		
		
	}
	
	
	public static void main(String[] args) {
		m2();
	}
}
