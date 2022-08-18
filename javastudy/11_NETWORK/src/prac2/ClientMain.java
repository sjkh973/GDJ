package prac2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		
		Socket socket = null;
		Scanner sc = null;
		BufferedWriter out =null;
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("localhost", 9090));
					
			Client client = new Client(socket);
			client.start();
			
			sc = new Scanner(System.in);
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 서버와 연결된 소켓에게 writer기능		
				
			while(true) {
				System.out.println(">>>");
				String message =sc.nextLine(); // 채팅내용입력		
				out.write(message + "\n"); // Client.java의 BufferedReader in으로 전달
				out.flush();
			}
			
		}catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(out != null) {
					out.close();
				}
				
			}catch (IOException e) {
				e.printStackTrace();
				
			}
		}
	

	}

}
