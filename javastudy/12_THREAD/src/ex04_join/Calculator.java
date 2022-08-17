package ex04_join;

public class Calculator implements Runnable{

	private long total;
	private long begin; 
	private long end;
	
	public Calculator(long begin, long end) {
		this.begin = begin;
		this.end = end;
	}
	
	public void add() {		
		for(long n = begin; n <= end; n++) {
			total += n;
		}
		
	}
	
	public long getTotal() {
		return total;
	}



	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public void run() {
		//start() 메소드를 사용하기 위해 run메소드에서 add메소드만 호출해준다.
		add();
		
	}
	
}
