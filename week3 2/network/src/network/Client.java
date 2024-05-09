package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
	public static void main(String [] args) throws Exception{
		Socket socket = new Socket("192.168.0.8", 26000);
		
		InputStream inputStream = socket.getInputStream();
		DataInputStream dis = new DataInputStream(inputStream);
		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(outputStream);
		while(true) {
			String msg = dis.readUTF();
			System.out.println(msg);
			
			dos.writeUTF(JOptionPane.showInputDialog("히히"));
			dos.flush();
		}
		
	}
}
