package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import DTO.FileDTO;

public class FileDAO {
	private static FileDAO instance;
	
	public synchronized static FileDAO getInstance() {
		if(instance == null) {
			instance = new FileDAO();
		}
		
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		
		return ds.getConnection();
	}
	
	public int insert(FileDTO dto) throws Exception {
		String insertSQL = "insert into files values(files_seq.nextval, ?, ?, ?)";
		int result = 0;
		try(Connection conn = this.getConnection();
				PreparedStatement pstmt = conn.prepareCall(insertSQL);){
			pstmt.setString(1, dto.getOriname());
			pstmt.setString(2, dto.getSysname());
			pstmt.setInt(3, dto.getParent_seq());
			result = pstmt.executeUpdate();
		}	return result;
	}
	
	public List<FileDTO> selectAll() throws Exception{
		String selectAllSQL ="select * from files";
		try(Connection conn = this.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectAllSQL);
				ResultSet rs = pstmt.executeQuery()){
			List<FileDTO> fileList = new ArrayList<>();
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String oriname = rs.getString("oriname");
				String sysname = rs.getString("sysname");
				int parent_seq = rs.getInt("parent_seq");
				FileDTO file = new FileDTO(seq, oriname, sysname, parent_seq);
				fileList.add(file);
			}
			
			return fileList;
		}
		}
}
