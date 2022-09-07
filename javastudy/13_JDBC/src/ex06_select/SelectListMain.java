package ex06_select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Board;

public class SelectListMain {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
			String user = "SCOTT"; // 
			String password = "TIGER"; 
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT BOARD_NO, TITLE, CONTENT, HIT, CREATE_DATE FROM BOARD ORDER BY BOARD_NO DESC";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
					
			// 모든 조회 결과를 저장할 ArrayList 생성
			List<Board> boards = new ArrayList<>();
			//
		
			
			// 다중 행이 조회되기 때문에 while문을 이용하여
			// 모든 행은 순차적으로 스캔
			while(rs.next()) {
				
				// rs가 가리키는 행 정보를 Board 객체로 생성
				Board board = new Board();
				board.setBoard_no(rs.getInt("BOARD_NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setHit(rs.getInt("HIT"));
				board.setCreate_date(rs.getDate("CREATE_DATE"));
		
				// Board 객체를 ArrayList에 저장
				boards.add(board);
			}
			
			// ArrayList에 저장된 Board 확인
			for(int i = 0; i < boards.size(); i++) {
				System.out.println(boards.get(i));
			}
			
			/*
			 for(Board board : boards){
			 	System.out.println(board);
			 }			 
			 */
	
		}catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				// 만드는 순서의 역순으로 close해준다.
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

}
