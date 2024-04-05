package FTPFileSystem;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String host = sc.next();
		String user = sc.next();
		String pwd = sc.next();
		// TODO Auto-generated method stub
		FTPSystem ftp = new FTPSystem(host, user, pwd);
		String remoteDir = "";
		String localPath = "";
		boolean uploadResult = ftp.fileUpload(remoteDir, localPath);
		System.out.print(uploadResult);
	}

}
