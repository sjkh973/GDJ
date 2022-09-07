package ex06_select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectOneMain2 {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB마다 url은 달라짐(Oracle XE 버전 기준)
			String user = "SCOTT"; // 대소문자 상관없음
			String password = "TIGER"; // 계정 만들 때 사용한 대소문자를 지켜야 함
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT COUNT(*)  FROM BOARD";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				/*
				   | COUNT(*) |
				   |    3     |  <= rs.next() 호출로 인해 현재 rs포인터의 위치 
				 
				   rs.getInt("총개수");
				  		또는
				   rs.getInt(1)		
				 */
				int count = rs.getInt("COUNT(*)");
				System.out.println(count);
				
			} // COUNT(*) 집계 함수의 결과는 else 처리할 필요가 없음
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
