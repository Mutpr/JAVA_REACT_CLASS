package week3_0417_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileThread{
	public static void main(String [] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 26000);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		DataInputStream dis = new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);
		
		int lg = dis.readInt();
		System.out.println(lg);
		
		for(int i=0; i<lg; i++) {
			String str = dis.readUTF();
			System.out.println(str);
		}
		
		String fileName = "file_test_test.txt";
		dos.writeUTF(fileName);
		
		long fileLength = dis.readLong();
		byte[] b = new byte[(int) fileLength];
		dis.readFully(b);
		
		FileOutputStream fos = new FileOutputStream("/Users/hyen/test_file"+fileName);
		DataOutputStream fdos = new DataOutputStream(fos);
		fdos.write(b);
		
		fdos.close();
		fos.close();
	}
}