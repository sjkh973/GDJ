package ex03_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import domain.Board;

public class InsertMain {

	public static void main(String[] args) {
		
		// 게시판 정보를 입력 받아서 BOARD 테이블에 저장하기
		// 1. Scanner 클래스로 정보 입력 받기
		// 2. Board 클래스 타입의 객체에 입력 받은 정보 저장하기

		Scanner sc = new Scanner(System.in);
		
		System.out.print("제목 >>>");
		String title = sc.nextLine();
		
		System.out.print("내용 >>>");
		String content = sc.nextLine();
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			// OracleDriver 클래스 로드
			// OracleDriver 클래스가 저장된 ojdbc6.jar 파일을 Classpath에 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			// DB접속 - Connection 객체 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB마다 url은 달라짐(Oracle XE 버전 기준)
			String user = "SCOTT"; // 대소문자 상관없음
			String password = "TIGER"; // 계정 만들 때 사용한 대소문자를 지켜야 함
			con = DriverManager.getConnection(url, user, password);
			// ? 는 변수 
			// HIT 조회수 초반값은 0이므로 0을 넣음
			
			// 쿼리문 작성(변수 처리할 부분은 ?로 처리)
			String sql = "INSERT INTO BOARD(BOARD_NO, TITLE, CONTENT, HIT, CREATE_DATE) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, 0, SYSDATE)";
			
			// PreparedStatement 객체 생성
			ps = con.prepareStatement(sql);
			
			// 쿼리문에 포함된 ?에 변수 전달하기
			// 쿼리문에 작성된 ?의 순서대로 명시하며 값을 채워줌
			ps.setString(1, board.getTitle()); // 1번째 ?에 board.getTitle() 전달하기 (setString : title이 String이므로)
			ps.setString(2, board.getContent()); // 2번째 ?에 board.getcontent() 전달하기 (setString : content이 String이므로)
			
			// INSERT문의 실행
			// 1. executeUpdate() 메소드 실행하기
			// 2. executeUpdate() 메소드 반환값은 int 타입
			// 3. 반환값
		    // 		1) 1이 반환되는 경우 : 1개의 행이 INSERT되었다는 의미, 성공을 의미함
			//		2) 0이 반환되는 경우 : 0개의 행이 INSERT되었다는 의미, 실패를 의미함
			
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	
	
	
}
