package library;

import java.util.Scanner;

public class Library {

	private Scanner sc;
	private Book[] books; //배열 객체 선언
	private int idx;
	
	public Library() {
		sc = new Scanner(System.in);
		books = new Book[100]; //선언된 배열에 배열을 생성하려면 new 클래스[갯수]; 하면됨
	}
	
	private void addBook() {
		if(idx == books.length) {
			System.out.println("자리가 없어요.");
			return;
		}
		System.out.println("===책등록===");
		System.out.print("제목 입력 >>>");
		String title = sc.next();
		System.out.print("저자 입력 >>>");
		String author = sc.next();
		Book book = new Book(idx + 1, title, author);
		books[idx++] = book; //books배열[idx++로 1개씩 증가] 에다가 book객체를 넣어줌
	}
	
	private void removeBook() {
		if(idx == 0) {
			System.out.println("등록된 책이 한 권도 없습니다.");
			return;
		}
		System.out.println("===책삭제===");
		System.out.print("삭제할 책의 번호(1~" + idx + ") >>> ");
		int bookNo = sc.nextInt();
		for(int i= 0; i <idx; i++) {
			if(books[i].getBookNo() == bookNo) {
				System.arraycopy(books, (i + 1), books, i, idx - (i - 1));
				books[--idx] = null;
				System.out.println("책 번호가 " + bookNo + "인 책을 삭제했습니다.");
				return;
			}
		}
		System.out.println("책 번호가" + bookNo + "인 책이 없습니다.");
	}
	
	private void findBook() {
		if(idx == 0) {
			System.out.println("등록된 책이 한권도 없습니다.");
			return;
		}
		System.out.println("===책조회===");
		System.out.print("조회할 책 제목 입력 >>> ");
		String title =sc.next();
		for(int i = 0; i < idx; i++) {
			// 저장된 책 제목 : books[i].getTitle
			// 조회할 책 제목 : title
			if(books[i].getTitle().equals(title)) { // if(title.equals(books[i].getTitle))
				System.out.println(books[i]);
				return; //findBook() 메소드 종료
			} 
			
		}
		System.out.println("제목이 " + title + "인 책은 없습니다.");

		
	}
	
	private void printAllBooks() {
		if(idx == 0) {
			System.out.println("등록된 책이 한권도 없습니다.");
			return;
		}
		System.out.println("===전체조회===");
		for(int i = 0; i < idx; i++) {
			System.out.println(books[i]);
		}
	}
	
	public void manage() {
		
		while(true) {
			System.out.print("1.추가 2.삭제 3.조회 4.전체목록 0.프로그램종료 >>>");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1 : addBook();break; 
			case 2 : removeBook();break; 
			case 3 : findBook();break; 
			case 4 : printAllBooks();break; 
			case 0 : System.out.println("Library 프로그램을 종료합니다. 감사합니다.");
					 return; // manage 메소드 종료
			default : System.out.println("알 수 없는 명령입니다. 다시 시도하세요."); 
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
