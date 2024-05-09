package week3_0417_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileThreadServer {
	/**
	 서버소켓 작동 -> 사용자가 하나 들어올때마다 스레드 하나가 작동
	 -> 
	 * @throws IOException **/
	public static void main(String [] args) throws IOException {
		ServerSocket server = new ServerSocket(26000);
		System.out.println("접속 대기");
		Socket socket = server.accept();
		
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		DataInputStream dis = new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);
		
		File home = new File("/Users/hyen/test_file");
		File[] list = home.listFiles();
		dos.writeInt(list.length);
		
		for(File f:list) {
			dos.writeUTF(f.getName());
		}dos.flush();
		
		String filename = dis.readUTF();
		
		File file = new File("/Users/hyen/test_file"+filename);
		byte[] b = new byte[(int) file.length()];
		dos.writeLong(file.length());
		
		FileInputStream fis = new FileInputStream("/Users/hyen/test_file"+filename);
		DataInputStream fileDis = new DataInputStream(fis);
		fileDis.readFully(b);
		
		dos.write(b);
		dos.flush();
		
		fis.close();
		}
}
