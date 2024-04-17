package week3_0417_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client extends Thread{
	private static DataOutputStream dos;
	private static DataInputStream dis;
	private static OutputStream os;
	private static InputStream is;
	
	public Client(DataOutputStream dos, DataInputStream dis, OutputStream os, InputStream is) {
		this.dos = dos;
		this.dis = dis;
		this.os = os;
		this.is = is;
	}
	public void run() {
		try {
			Scanner sc = new Scanner(System.in);
			String msg = sc.nextLine();
			dos.writeUTF(msg);

			String receivedMsg = dis.readUTF();
			System.out.println(receivedMsg);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


