package dom.gdu.app03.domain;


public class Board {
	
	//filed
	private int boardNo;
	private String title;
	private String createDate;
	
	
	public Board(int boardNo, String title, String createDate) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.createDate = createDate;
	}

	// constructor
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
	
	
	
}
