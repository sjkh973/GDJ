package ex02_create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DropTableMain {

	public static void main(String[] args) {
		
		Connection con  = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";
			String password = "TIGER";
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "DROP TABLE BOARD";
			ps = con.prepareStatement(password);
			
			ps.execute();
		}catch (ClassNotFoundException e) {
			System.out.println("OracleDriver 로드 실패");
		}catch (SQLException e) {
			System.out.println("DB접속정보 오류");
		} finally {
			
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
