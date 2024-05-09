package week3_0417_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client{
	public static void main(String []args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 26000);
		InputStream is=socket.getInputStream();
		OutputStream os=socket.getOutputStream();
		DataInputStream dis = new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);
		
		ReadThread read = new ReadThread(dis);
		read.start();
		
		while(true) {
			try {
				dos.writeUTF(JOptionPane.showInputDialog("보낼 메세지를 입력하세요."));
				dos.flush();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class ReadThread extends Thread{
	private DataInputStream dis;
	public ReadThread(DataInputStream dis) {
		this.dis = dis;
	}
	
	public void run() {
		try {
			while(true) {
				String msg = dis.readUTF();
				System.out.println(msg);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


