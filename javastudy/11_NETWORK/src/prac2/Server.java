package prac2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Server extends Thread{

	private Socket client; // 소켓이 클라이언트임(접속자) 
	private BufferedReader in;
	private BufferedWriter out;
	
	public Server(Socket client) {		
		try {
			this.client = client;
			in =  new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void sendMessage(String message) throws IOException{	
			out.write(message);
			out.flush();			
	}

	@Override
	public void run() {
		InetSocketAddress address= null;
		String message = null;	
		
		try {
		while(true) {
			message = in.readLine();
			if(message.equalsIgnoreCase("exit")) { // 채팅창에 exit 입력하면 채팅종료
				break;
			}
			//모든 클라이언트에게 메시지 출력
			address = (InetSocketAddress)client.getRemoteSocketAddress();
			ServerMain.sendMessage(address.getHostName() + "의 메시지 : " + message);
		}
		// List<Server> servers등록된 서버 제거
		ServerMain.servers.remove(this);
		System.out.println(address.getHostName() + " 채팅종료");
		
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
