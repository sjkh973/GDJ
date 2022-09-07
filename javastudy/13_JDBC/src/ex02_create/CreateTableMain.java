package ex02_create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTableMain {

	public static void main(String[] args) {
		
		// Connection 생성
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB마다 url은 달라짐(Oracle XE 버전 기준)
			String user = "SCOTT"; // 대소문자 상관없음
			String password = "TIGER"; // 계정 만들 때 사용한 대소문자를 지켜야 함
			con = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException e) {
			System.out.println("OracleDriver 로드 실패");
		}catch (SQLException e) {
			System.out.println("DB접속정보 오류");
		}
		
		// CREATE TABLE 실행
		PreparedStatement ps = null;
		try {
			
			// String 타입의 쿼리문 작성
			// 쿼리문의 마지막 세미콜론(;)은 JDBC에서 사용하지 않는다.
			StringBuilder sb = new StringBuilder();
			sb.append("CREATE TABLE BOARD(");
			sb.append("BOARD_NO NUMBER NOT NULL CONSTRAINT PK_BOARD PRIMARY KEY,");
			sb.append("TITLE VARCHAR2(100 BYTE) NOT NULL,");
			sb.append("CONTENT VARCHAR2(100 BYTE) NULL,");
			sb.append("HIT NUMBER NOT NULL,");
			sb.append("CREATE_DATE DATE NOT NULL)");
			String sql = sb.toString();
			
			// PreparedStatement 객체 생성
			// Prepared : 미리 준비하라.
			// Statement : 쿼리문
			// 역할 : 쿼리문 실행을 담당
			ps = con.prepareStatement(sql);
			
			// 쿼리문 실행
			ps.execute(); 
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		// Connection 닫기, PreparedStatement 닫기
		try {
			if (ps != null) ps.close();
			if (con != null)  con.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
