package dom.gdu.app03.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import dom.gdu.app03.domain.Board;
import dom.gdu.app03.domain.Notice;

	/*
	  	@RequestMapping(value="/" , method=RequestMethod.GET)
	 	
	 	Spring4부터 새로운 애너테이션으로 바꿀 수 있다.
	 	@GetMapping("/")
	 	@PostMapping("/")
	 */


@Controller
public class MyController {
	
	@GetMapping(value="/")	// http://localhost:9090/app03으로 접속하면 처리되는 메소드 
	public String welcome() {
		return "default";
		// ViewResolver에 의해서 
		// retrun "/WEB-INF/views/default.jsp
	}
	
	
	/* 
	 	Container에 등록된 Bean을 가져오는 방법
	  	
	  	1. @Inject 	
	  		1) 타입(class)이 일치하는 Bean을 가져오는 애너테이션
	  		2) 동일 타입이 여러 개 있는 경우 @Qualifier를 이용해서 Bean을 식별
	  	2. @Resource 	 
	  		1) 이름(id)이 일치하는 Bean을 가져오는 애너테이션
	  	3. @AutoWired
	  	  	1) 타입(class)이 일치하는 Bean을 가져오는 애너테이션
	  	  	2) 2) 동일 타입이 여러 개 있는 경우 @Qualifier를 이용해서 Bean을 식별
	  	  	3) 실무에서 주로 사용
	*/
	
	/* 
	  	@Autowired 사용 방법
	  	
	  	1. 필드로 생성된 Bean 가져오기
	  		1) 필드마다 @Autowired를 추가한다. (필드가 10개이면 @Autowired도 10번 작성)
	  		2) 필드가 많으면 사용하지 않는다.
  		2. 생성자를 이용해 Bean을 가져오기
  			1) 생성자의 매개변수로 Bean을 가져온다.
  			2) @Autowired를 작성할 필요가 없다.
		3. 메소드를 이용해 Bean을 가져오기
			1) 메소드의 매개변수로 Bean을 가져온다
			2) @Autowired를 작성해야 한다.
			3) 일반적으로 setter를 사용하지만 setter가 아니어도 상관 없다.
	 */
	
	// 1. 필드로 생성된 Bean을 가져오기
	//@Autowired				// autowired가 컨테이너에서 bean을 가져옴 
	//private Board board;    // 객체 변수명은 아무 역할을 하지않고 Autowired는 type만 확인 함

	
	/*
	  	@Autowired는 타입(class)이 일치하는 Bean을 Container에서 가져온다.
	  	
	  	@Autowired
	  	pirvate Board board; // 타입이 Board인 Bean을 Container에서 가져오거라.
	  	
	  	---- Container -----
	  	<bean id="board1" class="dom.gdu.app03.domain.Board">
	  	--------------------
	 
	 */
	

	// 2. 생성자를 이용해 Bean을 가져오기
	/*
	 * private Board board;
	 * 
	 * @Autowired // 생성자에는 @Autowired를 생략할 수 있다. 
	 * public MyController(Board board) {
	 * // 생성자의 매개변수타입을 보고 타입이 board인 Bean을 container에서 가져오거라 
	 * super(); 
	 * this.board = board; 
	 * }
	 * 
	 */
	
	// 3. 메소드를 이용홰 Bean 가져오기
	
	//private Board board;
	//@Autowired // 일반 메소드는 @Autowired를 반드시 작성해야 한다.
	//public MyController(Board board) { // 매개변수 Board board로 Board타입의 Bean을 Container에서 가져오거라
	
	
	
	//	super();
	//	this.board = board;
	//}

	// 4. 동일한 타입의 Bean이 여러 개 등록된 경우
	//	1) 변수명을 자동으로 식별자(Qualifier)로 인식한다.
	//  2) 식별자(@Qualifier)는 Bean의 이름(id)이 일치하는 Bean을 가져온다.
	
	// 동일한 타입 Board가 2개있으므로 Autowired의 두번째 방법인 이름으로 bean을가져온다 이름은 bean의 id이다.
	
	// 4 -1, 필드로 생성된 Bean을 가져오기
	/*
	@Autowired
	private Board board1;
	
	@Autowired
	private Board board2;
	*/
	
	// 4-2, 생성자를 이용해 Bean을 가져오기
	/*
	private Board b1;
	private Board b2;
	
	
	public MyController(Board board1, Board board2) {	// 매개변수명이 Bean의 이름(id)과 일치하므로 자동으로 주입된다.
		super();
		this.b1 = board1;
		this.b2 = board2;
	}
	*/
	
	//4-3. 메소드를 이용해 Bean을 가져오기
	private Board b1;
	private Board b2;
	
	@Autowired
	public void setBoard(Board board1, Board board2) {
		this.b1 = board1;
		this.b2 = board2;
	}
	
	@GetMapping("board/detail")  // @GetMapping("/board/detail")
	public void boardDetail() {
		System.out.println(b1.getBoardNo());
		System.out.println(b1.getTitle());
		System.out.println(b1.getCreateDate());
		System.out.println(b2.getBoardNo());
		System.out.println(b2.getTitle());
		System.out.println(b2.getCreateDate());
	}
	
	
	// @Autowired를 사용하는 이유 : @Inject + @Qualifier
	/*
	@Inject
	@Qualifier(value="board1")
	private Board b1;
	
	@Inject
	@Qualifier(value="board1")
	private Board b2;
	*/
	
	///////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private Notice notice1;
	@Autowired
	private Notice notice2;
	
	
	@GetMapping("notice/detail")
	public void noticeDetail() {
		System.out.println(notice1.getNoticeNo());
		System.out.println(notice1.getTitle());
		System.out.println(notice2.getNoticeNo());
		System.out.println(notice2.getTitle());
	}
}
