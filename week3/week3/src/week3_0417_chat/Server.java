package week3_0417_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(26000);
		Socket socket = server.accept();
		System.out.println(socket.getInetAddress());

		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		WriteThread wt = new WriteThread(dos);
		wt.start();

		while (true) {
			String msg = dis.readUTF();
			System.out.println("Clietn: " + msg);
		}
	}
}

class WriteThread extends Thread {
	private DataOutputStream dos;

	public WriteThread(DataOutputStream dos) {
		this.dos = dos;
	}

	public void run() {
		try {
			dos.writeUTF(JOptionPane.showInputDialog("보낼 메세지를 입력하세요."));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
