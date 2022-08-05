package quiz04_employee;

public class EmployeeException extends Exception{

	static final long serialVersionUID = -3387516993124229948L;
	
	private int errorCode;

	public EmployeeException(String message, int errorCode) {
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
