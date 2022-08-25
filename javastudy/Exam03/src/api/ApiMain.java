package api;

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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;





public class ApiMain {

	public static String m1() {
		
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
				
		String serviceKey = "PKpeco/Pq5XH7mMz9HmJhE7hlMDEhqsUvfqfzzkveinRe0CK4b2k2MKYnMaKQ7z891xIneUpF6/a10IdAmpA6g==";
		
		try {		
			urlBuilder.append("?ServiceKey=" + URLEncoder.encode(serviceKey,"UTF-8"));
			urlBuilder.append("&searchYear=2021");
			urlBuilder.append("&siDo=1100");
			urlBuilder.append("&guGun=1125");
			urlBuilder.append("&type=" + URLEncoder.encode("json","UTF-8"));
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
			urlBuilder.append("&resultCode=0000");
			urlBuilder.append("&resultMsg=" + URLEncoder.encode("Success", "UTF-8"));
			urlBuilder.append("&acc_year=2021");
			urlBuilder.append("&occrrnc_dt=2019011622");
			urlBuilder.append("&dght_cd=2");
			urlBuilder.append("&occrrnc_day_cd=4");
			urlBuilder.append("&dth_dnv_cnt=0");
			urlBuilder.append("&injpsn_cnt=1");
			urlBuilder.append("&se_dnv_cnt=1");
			urlBuilder.append("&sl_dnv_cnt=0");
			urlBuilder.append("&wnd_dnv_cnt=0");
			urlBuilder.append("&occrrnc_lc_sido_cd=1100");
			urlBuilder.append("&occrrnc_lc_sgg_cd=1125");
			urlBuilder.append("&acc_ty_lclas_cd=02");
			urlBuilder.append("&acc_ty_mlsfc_cd=23");
			urlBuilder.append("&acc_ty_cd=23");
			urlBuilder.append("&aslt_vtr_cd=01");
			urlBuilder.append("&road_frm_lclas_cd=01");
			urlBuilder.append("&road_frm_cd=04");
			urlBuilder.append("&wrngdo_isrty_vhcty_lclas_cd=01");
			urlBuilder.append("&dmge_isrty_vhcty_lclas_cd=01");
			urlBuilder.append("&occrrnc_lc_x_crd=943817");
			urlBuilder.append("&occrrnc_lc_y_crd=1945678");
			urlBuilder.append("&lo_crd=128.45275545");
			urlBuilder.append("&la_crd=35.94815032");
			urlBuilder.append("&totalCount=19");
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
			
					
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(urlBuilder.toString());
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET"); //생략가능 생략하면 자동으로 get방식임
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			
		}catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 주소 접속 실패");
		}
		
		// 입력 스트림(응답) 생성
		
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}		
			System.out.println(sb);
			
			br.close();
		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}
		
		
		
		/*
		 * try { BufferedWriter bw = new BufferedWriter(new FileWriter(new
		 * File("accident.json"))); bw.write(sb.toString()); bw.close();
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		return sb.toString();
	}
		
	public static void m2() {
		
		
		
		List<Accident> accidents = new ArrayList<>();
		
		JSONObject obj = new JSONObject(m1());
		JSONObject items = obj.getJSONObject("items");
		JSONArray item = items.getJSONArray("item");
		
		for(int i = 0; i < item.length(); i++) {
			JSONObject element = item.getJSONObject(i);
			String occrrncDt = element.getString("occrrnc_dt");
			String occrrncDayCd =element.getString("occrrnc_day_cd");
			int dthDnvCnt = element.getInt("dth_dnv_cnt");
			int injpsnCnt= element.getInt("injpsn_cnt");			
			
			Accident accident = Accident.builder()
					.occrrncDt(occrrncDt)
					.occrrncDayCd(occrrncDayCd)
					.dthDnvCnt(dthDnvCnt)
					.injpsnCnt(injpsnCnt)
					.build();
			
			accidents.add(accident);			
		
			System.out.println("발생일자 " + occrrncDt + " " +occrrncDayCd + " 사망자수" +dthDnvCnt +"명," + "부상자수 " + injpsnCnt+"명");
			
			
			
		} //for
		String str = "";			
 
		for(Accident accident2 : accidents) {	
			switch (accident2.getOccrrncDayCd()) {
			case "1" : System.out.println("일요일"); break;
			case "2" : System.out.println("월요일"); break;
			case "3" : System.out.println("화요일"); break;
			case "4" : System.out.println("수요일"); break;
			case "5" : System.out.println("목요일"); break;
			case "6" : System.out.println("금요일"); break;
			default :  System.out.println("토요일");		
			}
			
			
			System.out.println(str +="발생일자 " + accident2.getOccrrncDt() + " " + accident2.getOccrrncDayCd() + "요일, 사망자수" + accident2.getDthDnvCnt() + "명," + "부상자수" + accident2.getInjpsnCnt() + "명\n"  );
		}	
		
		File file = new File("accident.txt");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(str);
			bw.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		 m2();
		
	}

}
