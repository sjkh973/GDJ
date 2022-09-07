package ex06_select;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Board;

public class SelectOneMain {

	public static void main(String[] args) {
		
		// SELECT문 실행
		// 1. executeQuery() 메소드 이용
		// 2. ResultSet 객체로 실행결과 저장
		
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			
			//OracleDriver 로드
			Class.forName("oracle.jdbc.OracleDriver");
			// Connection 객체 생성	
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB마다 url은 달라짐(Oracle XE 버전 기준)
			String user = "SCOTT"; // 대소문자 상관없음
			String password = "TIGER"; // 계정 만들 때 사용한 대소문자를 지켜야 함
			con = DriverManager.getConnection(url, user, password);
			
			// 쿼리문 작성
			// SELECT문의 결과가 단일 행인 경우
			// 1. WHERE절에서 조건 PK또는 UNIQUE 칼럼과 동등 비교(=)를 수행
			// 2. 집계 함수의 결과를 조회
			
			String sql = "SELECT BOARD_NO, TITLE, CONTENT, HIT, CREATE_DATE FROM BOARD WHERE BOARD_NO = 5";
			
			// PreparedStatement 객체 생성
			ps = con.prepareStatement(sql);
			
			// 쿼리문 실행
			rs = ps.executeQuery();
			
			// 조회 결과를 행 단위로 스캔 rs 객체
			// rs.next() 메소드 호출로 조회 결과를 스캔할 수 있음
			// rs.next() 메소드 호출 1건 = 1행 스캔
			// rs.next() 메소드는 스캔 성공 시 true, 스캔 실패 시 false 반환
			
			// 조회 결과 1개인 경우
			// rs.next() 메소드 호출은 1번
			
			if(rs.next()) { //스캔 성공하면(조회 결과가 있으면)
				System.out.println("성공");
				/*
				 rs 객체는 행 전체를 가리키는 포인터 역할
				 rs 객체를 통해서 행을 구성하는 열(칼럼)정보를 가져올 수 있음
				 
				 | BOARD_NO | TITLE | CONTENT | HIT | CREATE_DATE |
				 |     5    | 공지1 |  내용2  |  0  |   22/09/07  | < = rs.next() 호출 시 rs의 위치   
				 
				 rs 객체의 칼럼 정보 가져오기
				 1. 칼럼의 이름
				 	1) rs.getInt("BOARD_NO");
				 	2) rs.getString("TITLE");
					3) rs.getString("CONTENT");
				    4) rs.getInt("HIT");
				    5) rs.getDate("CREATE_DATE");
				    
				 2. 칼럼의 순서(번호)
				 	1) rs.getInt(1)
				 	2) rs.getString(2)
				 	3) rs.getString(3)
				 	4) rs.getInt(4)
				 	5) rs.getDate(5)
				*/
				int board_no = rs.getInt("BOARD_NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				int hit = rs.getInt("HIT");
				Date create_date = rs.getDate("CREATE_DATE");
				
				// 모든 칼럼의 정보를 하나의 Board 객체로 만듬
				
				  Board board = new Board(); 
				  board.setBoard_no(board_no);
				  board.setTitle(title); 
				  board.setContent(content); 
				  board.setHit(hit);
				  board.setCreate_date(create_date);
				
				//확인
				System.out.println(board); // Board 클래스의 toString() 메소드 동작
		
				
			} else {
				System.out.println("조회결과가 없습니다.");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {		
			// con, rs, ps 닫기
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
