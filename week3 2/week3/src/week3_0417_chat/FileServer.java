package week3_0417_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(26000);
		try {
			while (true) {
				System.out.println("클라이언트 접속 대기중");
				Socket socket = server.accept();
				System.out.println(socket.getInetAddress() + "/에서 접속");
				
					DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
					DataInputStream dis = new DataInputStream(socket.getInputStream());
					
					File file = new File("/Users/hyen/test_File");
					File[] list = file.listFiles();
					dos.writeInt(list.length);
					for(File f: list) {
						dos.writeUTF(f.getName());
					}
					dos.flush();
					
					String filename = dis.readUTF();
					System.out.println(filename);
					File fileFullPath = new File("/Users/hyen/test_File"+"/"+filename);
					FileInputStream fis = new FileInputStream(fileFullPath);
					DataInputStream fsis = new DataInputStream(fis);
					
					byte[] fileConstants = new byte[(int) file.length()];
					fsis.readFully(fileConstants);
					dos.writeLong(fileConstants.length);
					
					dos.flush();
					fsis.close();

					
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
