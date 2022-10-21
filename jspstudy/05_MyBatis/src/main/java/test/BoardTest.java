package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import domain.Board;
import repository.BoardDao;

/*

	JUnit 단위 테스트
	
	1. DAO의 메소드 단위로 단위 테스트를 수행한다.
	2. Service 실행 결과가 '특정값'인 경우 Service를 대상으로 단위 테스트를수행할 수 있다.
	3. 프로젝트의 Build Path에서 JUnit 라이버르러리를 추가하고 사용한다.
	4. 테스트 수행
		프로젝트 실행 : RUN - JUnit 
	5. 주요 에너테이션
		1) @Test   : 단위 테스트를 수행하는 메소드
		2) @Before : 단위 테스트 수행 이전에 실행하는 메소드
		3) @After  : 단위 테스트 수행 이후에 실행하는 메소드
*/	

public class BoardTest {

	@Test
	public void 목록테스트() {		// 메소드명으로 한글을 많이 사용한다.
		
		// 목록의 개수가 5개이면 테스트 성공, 아니면 실패
		List<Board> boards = BoardDao.getInstance().selectAllBoards();
		assertEquals(4, boards.size());
	}
	
	@Test
	public void 상세조회() {
		
		// 4번 게시글의 제목이 '공지4'이면 테스트 성공, 아니면 실패
		/*
		 * Board board = BoardDao.getInstance().selectBoardByNo(4); assertEquals("공지4",
		 * board.getTitle());
		 */
		
		// 4번 게시글을 가진 게시글이 있으면 테스트 성공, 아니면 실패
		Board board = BoardDao.getInstance().selectBoardByNo(10);
		assertNotNull(board); // board가 not null이면 테스트 성공
	}
	
	@Test
	public void 게시글삽입테스트() {
		// 제목 : 테스트
		// 내용 : 테스트 내용
		Board board = new Board();
		board.setTitle("테스트");
		board.setContent("테스트 내용");
		int result = BoardDao.getInstance().insertBoard(board);
		assertEquals(1, result);
	}
	
	@Test
	public void 게시글수정테스트() {
		// 제목 : 테스트2
		// 내용 : 테스트 내용2
		Board board = new Board();
		board.setTitle("테스트2");
		board.setContent("테스트 내용2");
		board.setBoardNo(11); // 게시글 삽입 테스트 결과로 삽입된 게시글 번호
		int result = BoardDao.getInstance().updateBoard(board);
		assertEquals(1, result);
	}
	
	@Test
	public void 게시글삭제테스트() {
		// 게시글삽입테스트로 삽입한 게시글 삭제
		int result = BoardDao.getInstance().deleteBoard(12);
		assertEquals(1, result);
		
		
	}
	
}
