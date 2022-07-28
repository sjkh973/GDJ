package ex07_constructor;

public class ComputerMain {

	public static void main(String[] args) {
		
		Computer myCom = new Computer("gram", 150); // 디폴트 생성자로 인하여 객체 생성가능
		myCom.printComputerStatus();

		Computer yourCom = new Computer();
		yourCom.printComputerStatus();
	}

}
