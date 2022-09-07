package ex02_create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateSequenceMain {

	public static void main(String[] args) {
		
		// Connection 생성
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			// Connection 생성
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";
			String password = "TIGER";
			con = DriverManager.getConnection(url,user,password);
			
			// 쿼리문 작성
			String sql = "CREATE SEQUENCE BOARD_SEQ NOCACHE";
			
			// PreparedStatement 객체 생성
			ps = con.prepareStatement(sql);
			
			// 쿼리문 실행
			ps.execute();
			
		}catch (ClassNotFoundException e) {
			System.out.println("OracleDriver 로드 실패");
		}catch (SQLException e) {
			System.out.println("DB접속정보 오류");
		} finally {
			
			// Connection 닫기, PreparedStatement 닫기
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
	}

}
