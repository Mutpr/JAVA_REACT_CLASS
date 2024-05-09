package exam02;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class week3 {
	public static void main(String[] args) throws IOException {
//		ServerSocket server = new ServerSocket(26000);
//		Socket sock = server.accept();
		Scanner sc = new Scanner(System.in);
		int [] lottery = new int[4];
//		InputStream inputStream = sock.getInputStream();
//		DataInputStream dis = new DataInputStream(inputStream);
//		OutputStream outputStream = sock.getOutputStream();
//		DataOutputStream dos = new DataOutputStream(outputStream);

		while (true) {
			String msg = sc.nextLine();
			int sg = Integer.parseInt(msg);
			System.out.println("입력값: " + msg);
			String joinString = null;
			try {
				if (sg == 1) {
					for (int i : lottery) {
						lottery[i] = (int) (Math.random() * 100 + 1);
						System.out.print(lottery[i]+" ");
					}
					System.out.println(Arrays.toString(lottery));
					System.out.println(joinString);
//					}
//					dos.flush();
					continue;
				}
//				}else if(msg == 2) {
//					
//					msg = dis.readInt();
//					System.out.println(msg);
//					continue;
//			
//				}
			} catch (Exception e) {
				break;
			}
		}
	}
}
