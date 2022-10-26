package test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.junit.Test;

public class MemberTest {

	@Test
	public void 회원목록테스트() {
		
		// 회원목록을 반환하는 MemberListService() 동작 전반을 살펴보는 테스트
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			
			String apiURL = "http://localhost:9090/07_Ajax/member/list.do";
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			JSONObject obj = new JSONObject(sb.toString());
			assertEquals(3, obj.getInt("count")); // 테스트 결과가 3가되면 테스트 통과
			
			System.out.println("회원수 : " + obj.getInt("count"));
			
			reader.close();
			con.disconnect();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
