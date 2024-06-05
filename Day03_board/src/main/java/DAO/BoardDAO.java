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

import DTO.BoardDTO;

public class BoardDAO {
	   private static BoardDAO instance;
	   public synchronized static BoardDAO getInstance() {
	      if(instance ==null) {
	         instance = new BoardDAO();
	      }
	      return instance;
	   }
	   private Connection getConnection() throws Exception{
	      Context ctx= new InitialContext();
	      DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
	      return ds.getConnection();
	   }
	   private BoardDAO() {}
	   
	public List<BoardDTO> selectAllPost() throws Exception {
		List<BoardDTO> postList = new ArrayList<>();
		String selectAllPostSQL = "select * from board";
		try (Connection conn = this.getConnection(); PreparedStatement pstmt = conn.prepareStatement(selectAllPostSQL); ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String contents = rs.getString("contents");
				Timestamp write_date = rs.getTimestamp("write_date");
				String title = rs.getString("title");
				BoardDTO post = new BoardDTO(seq, writer, contents, write_date, title);
				postList.add(post);
			}
			return postList;

		}
	}

	public BoardDTO selectOnePost(int postSeq) throws Exception {
		BoardDTO post = new BoardDTO();
		String selectOnePostSQL = "select * from board where seq=?";
		try (Connection conn = this.getConnection(); PreparedStatement pstmt = conn.prepareStatement(selectOnePostSQL);) {
			pstmt.setInt(1, postSeq);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String writer = rs.getString("writer");
				Timestamp write_date = rs.getTimestamp("write_date");
				post = new BoardDTO(postSeq, writer, contents, write_date, title);
			}
		}
		return post;
	}
	
	public int updatePost(int postId, String updatedContents, String updatedTitle){
		int result = 0;
		String updatePostSQL = "update board set title=?, contents=? where seq=?";
		try(Connection conn = this.getConnection(); PreparedStatement pstmt = conn.prepareStatement(updatePostSQL);){
			pstmt.setString(1, updatedTitle);
			pstmt.setString(2, updatedContents);
			pstmt.setInt(3, postId);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int insertPost(String title, String contents, String writerId) {
		int result = 0;
		String insertPostSQL = "insert into board values(board_seq.nextval, ?, ?, sysdate, ?)";
		try(Connection conn = this.getConnection(); PreparedStatement pstmt = conn.prepareStatement(insertPostSQL);){
			pstmt.setString(1, writerId);
			pstmt.setString(2, contents);
			pstmt.setString(3, title);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deletePost(int postId) {
		int result = 0;
		String deletePostSQL = "delete from board where seq =?";
		try(Connection conn = this.getConnection(); PreparedStatement pstmt = conn.prepareStatement(deletePostSQL);){
			pstmt.setInt(1, postId);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
