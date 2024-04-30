package week5_0430_Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

public class Server {
	private static String getSha512(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = plainText.getBytes(Charset.forName("UTF-8"));
			md.update(bytes);
			return new String(Base64.getEncoder().encode(md.digest()));
		} catch (Exception e) {
			System.out.println("Sha512 error.");
			e.printStackTrace();
		}
		return null;
	}

	final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String id = "KH";
	final static String pw = "KH";

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(30000);
			Socket socket = server.accept();
			System.out.println(socket.getInetAddress() + " 로부터 접속");

			InputStream inputStream = socket.getInputStream();
			DataInputStream dis = new DataInputStream(inputStream);
			OutputStream outputStream = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(outputStream);
			menu: while (true) {
				int menuSelect = dis.readInt();
				// 로그인
				if (menuSelect == 1) {
					String id = dis.readUTF();
					String pw = dis.readUTF();

					try (Connection con = getConnection(); Statement stmt = con.createStatement();) {
						String selectSQL = "select * from members where id = '" + id + "'and (select convert(aes_encrypt("+ pw + ",(sha2('key',%064x)using UTF8)";
						ResultSet selectResult = stmt.executeQuery(selectSQL);
						while (selectResult.next()) {
							System.out.print(selectResult.getString("id"));
							System.out.print(selectResult.getString("pw"));
							System.out.print(selectResult.getString("name"));
							dos.writeBoolean(true);
							dos.flush();
							if (selectResult.next() == false) {
								dos.writeBoolean(false);
								dos.flush();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					continue menu;
					// 회원가입
				} else if (menuSelect == 2) {
					String id = dis.readUTF();
					String pw = dis.readUTF();
					String name = dis.readUTF();
					try (Connection con = getConnection(); Statement stmt = con.createStatement();) {
						String insertSQL = "insert into members values('" + id + "','" + pw + "','" + name + "')";

						int insertResult = stmt.executeUpdate(insertSQL);
						System.out.println(insertResult);
						if (insertResult > 0) {
							dos.writeBoolean(true);
							dos.flush();
						} else {
							dos.writeBoolean(false);
							dos.flush();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					continue menu;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(url, id, pw);
		return con;
	}

	public static String getSHA512(String input) {
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
