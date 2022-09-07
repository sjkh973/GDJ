package ex05_delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteMain {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			// 삭제할 게시글 번호 입력 받기
			Scanner sc = new Scanner(System.in);
			System.out.print("삭제할 게시글 번호 입력>>>");
			int BoardNo = sc.nextInt();
			sc.nextLine(); // 엔터 먹기
			
			// Connection 생성
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB마다 url은 달라짐(Oracle XE 버전 기준)
			String user = "SCOTT"; // 대소문자 상관없음
			String password = "TIGER"; // 계정 만들 때 사용한 대소문자를 지켜야 함
			
			con = DriverManager.getConnection(url, user, password);
			
			// 쿼리문 생성
			String sql = "DELETE FROM BOARD WHERE BOARD_NO= ?";
			
			// PreparedStatement 객체 생성
			ps = con.prepareStatement(sql);
			
			// 쿼리문의 ?에 변수 전달
			ps.setInt(1, BoardNo);
			
			//쿼리문실행
			int result = ps.executeUpdate();
			
			// 실행결과		
			// 업데이트 성공, 업데이트 실패
			if(result > 0 ) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			// con, ps 닫기
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}	
				

	}

}
