package basic_03_Movie_Quiz01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDAO {
//	DBConnection dbConnection = new DBConnection();
//	Connection conn = dbConnection.getConnection();
//	PreparedStatement pstmt;
//
//	@Override
//	public int insert(String insertSQL, int id,String title, String genre) {
//		int insertResult = 0;
//		try {
//
//			pstmt = conn.prepareStatement(insertSQL);
//			insertSQL = "insert into movie values(?, ?, ?, sysdate)";
//			pstmt.setInt(1, id);
//			pstmt.setString(2, title);
//			pstmt.setString(3, genre);
//			insertResult = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return insertResult;
//	}
//
//	@Override
//	public int delete(String deleteSQL, int id) {
//		deleteSQL = "delete from movie where id=?";
//		int deleteResult = 0;
//		try {
//			pstmt.setInt(1, id);
//			pstmt = conn.prepareStatement(deleteSQL);
//			deleteResult = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return deleteResult;
//	}
//	
//
//	public ArrayList<Object> read(String readSQL) {
//		
//		try {
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public int update(String updateSQL) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
