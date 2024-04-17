package week3_0417_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FileClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 26000);
		Scanner sc = new Scanner(System.in);
		
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		DataInputStream dis = new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);

		String filename = sc.nextLine();
		File file = new File(filename);
		
		FileInputStream fis = new FileInputStream(file);
		byte [] tmp = new byte[1024];
		int c = 0;
		while((c = is.read(tmp))!= -1) {
			fis.read(tmp);
		}
		fis.close();

	}
}
