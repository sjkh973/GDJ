package prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client extends Thread {

	private BufferedReader in;

	public Client(Socket socket) {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		try {
			while(true) {
				String message = in.readLine();
				if(message == null || message.equalsIgnoreCase("exit")) {
					break;
				}
				System.out.println(message);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) {
					in.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}