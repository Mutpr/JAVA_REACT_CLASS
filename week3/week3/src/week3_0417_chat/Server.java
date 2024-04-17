package week3_0417_chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String [] args) throws IOException {
		ServerSocket server = new ServerSocket(26000);
		Socket socket = server.accept();
	}
}
