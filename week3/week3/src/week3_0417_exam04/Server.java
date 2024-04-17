package week3_0417_exam04;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stubS
		ServerSocket server = new ServerSocket(40000);
		while(true) {
			Socket socket = server.accept();
			//메세지가 동시에 보내지면 접속이 안되게 되어있음(readUTF때문에 코드가 멈춰있음)
			
			
			try {
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				String msg = dis.readUTF();
				System.out.println(socket.getInetAddress()+"의 메세지: "+msg);
			}catch(Exception e) {
				System.out.println(socket.getInetAddress()+"의 접속 해제");
				e.printStackTrace();
			}
		}
	}

}
