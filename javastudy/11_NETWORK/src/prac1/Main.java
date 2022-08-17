package prac1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class Main {

	public static void main(String[] args) {
		
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

}
