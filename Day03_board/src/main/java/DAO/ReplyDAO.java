package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import DTO.ReplyDTO;

public class ReplyDAO {
	private static ReplyDAO instance;

	public synchronized static ReplyDAO getInstance() {
		if (instance == null) {
			instance = new ReplyDAO();
		}
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	private ReplyDAO() {
	}

	public List<ReplyDTO> selectAllReply(int postId) {
		String selectAllReplySQL = "select * from reply where parent_seq = ?";
		List<ReplyDTO> replyList = new ArrayList<ReplyDTO>();
		ReplyDTO reply = new ReplyDTO();
		try (Connection conn = this.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectAllReplySQL);) {
			pstmt.setInt(1, postId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String content = rs.getString("contents");
				Timestamp writer_date = rs.getTimestamp("writer_date");
				
				reply = new ReplyDTO(seq, writer, content, writer_date, postId);
				replyList.add(reply);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return replyList;
	}
	
	public int insertReply(String contents, String writer, int postId) {
		int result = 0;
		String insertPostSQL = "insert into reply values(board_seq.nextval, ?, ?, sysdate, ?)";
		try(Connection conn = this.getConnection(); PreparedStatement pstmt = conn.prepareStatement(insertPostSQL);){
			pstmt.setString(1, writer);
			pstmt.setString(2, contents);
			pstmt.setInt(3, postId);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
