package prac3;

public class Bakery {

	private int price; //빵가격
	private int cnt;  //빵갯수
	private int money; // 자본금
	
	public Bakery(int price, int cnt, int money) {
		super();
		this.price = price;
		this.cnt = cnt;
		this.money = money;
	}

	//판매
	//throws RuntimeException 생략 가능
	//custMoney 고객의 가진 돈
	public BreadAndChange sell(int custMoney) throws RuntimeException{
		if(custMoney < price) {
			throw new RuntimeException("판매불가");
		}
		
		//판매할 수 있는 빵은 몇개인가?
		int sellCnt = custMoney / price;
		
		//잔돈은 얼마인가?
		int change = custMoney % price;
		
		// 매장 내부의 변화 처리
		cnt-= sellCnt;
		money += (custMoney -change);
		
		//고객에게 되돌려줄 빵과 잔돈
		return new BreadAndChange(sellCnt, change);
		
	}

	
	
	public void info() {
		System.out.println("빵: " + cnt + "개, 자본금 " + money + "원");	
	}
}
