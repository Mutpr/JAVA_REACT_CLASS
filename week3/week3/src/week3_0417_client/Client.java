package week3_0417_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String [] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 26000);
		InputStream is=socket.getInputStream();
		OutputStream os=socket.getOutputStream();
		DataInputStream dis = new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);
		
		int lg=dis.readInt();
		System.out.println(lg);
		
		for(int i=0; i<lg; i++) {
			String str = dis.readUTF();
			System.out.println(str);
		}
		String filename = "가능?";
		
		dos.writeUTF(filename);
		
		
	}
}
