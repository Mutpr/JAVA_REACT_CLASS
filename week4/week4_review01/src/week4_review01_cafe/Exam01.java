package week4_review01_cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Exam01 {
	public static void main(String [] args) throws SQLException {
		Connection con = DriverManager.getConnection(null, null, null);
		Statement statement = con.createStatement();
		String sql = "";
		
		int result = statement.executeUpdate(sql);
		if(result > 0) {
			System.out.println("입력성공");
		}
		con.close();
	}
}
