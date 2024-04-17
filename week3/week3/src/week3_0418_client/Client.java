package week3_0418_client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("192.168.0.161", 30000);
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		
		int size = dis.readInt();
		String downDir = "";
		
		
		System.out.println(size);
		
		for(int i=0; i<size; i++) {
			String title = dis.readUTF();
			System.out.println(title);
		}
		
	}

}
