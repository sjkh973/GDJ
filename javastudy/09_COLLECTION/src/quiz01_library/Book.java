package quiz01_library;


public class Book {

	private int bookNo;    // 1 ~ 100까지 자동부여
	private String title;  // 사용자 입력
	private String author; // 사용자 입력
	
	
	public Book() {
		// TODO Auto-generated constructor stub
	}


	public Book(int bookNo, String title, String author) {
		super();
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
	}

	
	

	public int getBookNo() {
		return bookNo;
	}


	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", title=" + title + ", author=" + author + "]";
	}
	

	//객체와 객체를 .equals 메소드로 비교했을때는 번지수로 비교한다
	// 아래의 equals를 오버라이드 해주면 내용으로 비교 가능
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookNo != other.bookNo)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	
	
}
