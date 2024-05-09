package FTPFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPSystem {
	FTPClient client = new FTPClient();
	public FTPSystem(String host, String user, String pwd) throws Exception {
		client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		client.connect(host);
		int reply = client.getReplyCode();
		if(!FTPReply.isPositiveCompletion(reply)) {
			client.disconnect();
			throw new Exception("에러발생~!");
		}
		
		client.login(user, pwd);
		client.setFileType(FTP.BINARY_FILE_TYPE);
		client.enterLocalPassiveMode();
	}
	
	public boolean fileUpload(String remoteDirPath, String localPath) throws IOException {
		FileInputStream input = new FileInputStream(localPath);
			return client.storeFile(remoteDirPath, input);
	}

}
