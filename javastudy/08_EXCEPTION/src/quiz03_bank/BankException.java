package quiz03_bank;

public class BankException extends Exception{

	// 마이너스 입금 불가, 코드 값 1000
	// 마이너스 출금 불가, 코드 값 2000
	// 잔액보다 큰 출금 불가, 코드 값 2001
	private static final long serialVersionUID = -7774118171104436322L;	
	private int errorCode;

	public BankException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	
}
