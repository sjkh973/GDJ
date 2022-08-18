package prac2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {

	// Server : 스레드
	// Client : 스레드
	// Server 하나 당 Client 하나 담당
	
	// 생성된 Server 몰록
	public static List<Server> servers = new ArrayList<>(); // <> 안쪽 생략가능
	
	//모든 Server에 메시지 전송
	
	public static void sendMessage(String message) throws IOException{
		for(Server server : servers) {
			server.sendMessage(message);
		}
		
	}
	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket client = null;
		
		try {
			server = new ServerSocket();
			server.bind(new InetSocketAddress("localhost", 9090));
			System.out.println("♠채팅 서버 오픈");
	
			while(true) {
				
				//서버 중지 조건은 없는 상태임
				client = server.accept(); //클라이언트 접속
				Server s = new Server(client);
				servers.add(s);
				s.start();
				System.out.println("현재 접속 중인 클라이언트" + servers.size() + "명");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(server.isClosed() == false) {
					server.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}

}
