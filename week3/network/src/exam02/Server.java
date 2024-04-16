package exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
	public static void main(String [] args) throws IOException {
		ServerSocket server=new ServerSocket(26000);
		Socket sock = server.accept();
		
		System.out.println(sock.getInetAddress()+"/로부터 접속");
		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		while(true) {
			dos.writeUTF(JOptionPane.showInputDialog("실습"));
			dos.flush();
			
			String msg = dis.readUTF();
			System.out.println(msg);
		}
		
	}
}
