package ex07_constructor;

public class ComputerMain {

	public static void main(String[] args) {
		
		Computer computer = new Computer();
		
		computer.printComputerStatus();
		
		Computer com = new Computer("삼성노트북", 150);
		
		com.printComputerStatus();
		
		
	}

}
