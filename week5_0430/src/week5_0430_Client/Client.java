package week5_0430_Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("192.168.1.35", 30000);
		Scanner sc = new Scanner(System.in);

		InputStream inputStream = socket.getInputStream();
		DataInputStream dis = new DataInputStream(inputStream);
		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(outputStream);

		menu: while (true) {
			System.out.println("1. 로그인 2. 회원가입");
			int menuSelect = Integer.parseInt(sc.nextLine());
			dos.writeInt(menuSelect);
			if (menuSelect == 1) {
				String id = sc.nextLine();
				String pw = sc.nextLine();
				dos.writeUTF(id);
				dos.writeUTF(getSHA512(pw));
				if (dis.readBoolean() == true) {
					System.out.println("로그인 성공");
					continue menu;
				} else {
					System.out.println("로그인 실패");
					continue menu;
				}
			} else if (menuSelect == 2) {
				System.out.println("회원가입할 아이디 입력");
				String newId = sc.nextLine();
				dos.writeUTF(newId);
				
				System.out.println("회원가입할 비밀번호 입력");
				String newPw = sc.nextLine();
				dos.writeUTF(getSHA512(newPw));
				dos.flush();
				
				System.out.println("회원가입할 이름 입력");
				String newName = sc.nextLine();
				dos.writeUTF(newName);
				dos.flush();
				
				if(dis.readBoolean()==true) {
					System.out.println("회원가입 성공");
				}else {
					System.out.println("회원가입 실패");
				}
				continue menu;

			}
		}

	}
	
	public static String getSHA512(String input){
	      String toReturn = null;
	      try {
	          MessageDigest digest = MessageDigest.getInstance("SHA-512");
	          digest.reset();
	          digest.update(input.getBytes("utf8"));
	          toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
	      } catch (Exception e) {
	          e.printStackTrace();
	      }
	      return toReturn;
	    }

}
