package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DTO.MessagesDTO;

public class MessagesDAO implements DAO {


	String author;
	String contents;

	public MessagesDAO(String author, String contents) {
		this.author = author;
		this.contents = contents;
	}

	DBConnection dbConnection = new DBConnection();
	Connection conn = dbConnection.getConnection();
	PreparedStatement pstmt;

	@Override
	public int insert() {
		int result = 0;
		String insertSQL = "insert into messages values(messages_seq.nextval,?,?,sysdate)";
		try {

			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, contents);
			pstmt.setString(2, author);
			result = pstmt.executeUpdate();

			if (result == 0) {
				System.out.println("입력 실패");
			} else if (result == 1) {
				System.out.println("입력 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int delete(int id) {
		int result = 0;
		String deleteSQL = "delete from messages where id=?";
		try {
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
			
			if (result == 0) {
				System.out.println("입력 실패");
			} else if (result == 1) {
				System.out.println("입력 성공");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<MessagesDTO> selectAll() {
		List<MessagesDTO> messageList = new ArrayList<>();
		String selectAllSQL = "select * from messages";
		try {
			pstmt = conn.prepareStatement(selectAllSQL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String contents = rs.getString("message");
				String author = rs.getString("author");
				Timestamp reg_date = rs.getTimestamp("reg_date");
				MessagesDTO message = new MessagesDTO(id, contents, author, reg_date);
				messageList.add(message);
			}
			for(MessagesDTO message: messageList) {
				System.out.println(message.getMessage());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
	}

	@Override
	public MessagesDTO selectOneById(int id) {
		MessagesDTO message = null;
		String selectOneById = "select * from messages where id = ?";
		try {
			pstmt = conn.prepareStatement(selectOneById);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String contents = rs.getString("message");
				String author = rs.getString("author");
				Timestamp reg_time = rs.getTimestamp("reg_date");
				message = new MessagesDTO(id, contents, author, reg_time);
			}
			System.out.println(message.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return message;
	}

}
