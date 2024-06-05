package DAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Controller.DBConnection;
import DTO.UserDTO;

public class UserDAO {
	Connection conn = this.getConnection();
	PreparedStatement pstmt;
	String id;
	String pwd;

	public UserDAO() {
		super();
	}

	public UserDAO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			DBConnection dbConnection = new DBConnection();
			conn = dbConnection.getConnection();
			System.out.println("connection:" + conn);

			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

//	public boolean userLogin(String id, String pwd) {
//		
//	}
	// 아이디 중복 검사
	public boolean isIdDuplicated(String id) {
		String isIdDuplicatedSQL = "SELECT id FROM members WHERE id = ?";
		try {
			pstmt = conn.prepareStatement(isIdDuplicatedSQL);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs.next(); // 아이디가 존재하면 true 반환

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 아이디가 존재하지 않으면 false 반환
	}

	public int insertUser(String id, String pwd, String name, String phoneNumber, String email, String postcode,
			String address1, String address2, String extraAddress) {
		String insertSQL = "insert into members values(?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		address2 += extraAddress;
		System.out.println(address2);

		int result = 0;
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, id);
			pstmt.setString(2, getSHA512(pwd));
			pstmt.setString(3, name);
			pstmt.setString(4, phoneNumber);
			pstmt.setString(5, email);
			pstmt.setString(6, postcode);
			pstmt.setString(7, address1);
			pstmt.setString(8, address2);

			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public UserDTO selectAllById(String id, String pwd) {
		String selectAllByIdSQL = "select id, name, phone, email, zipcode, address1, address2, join_date from members where id = ? and pw =?";
		UserDTO userInfo = null;
		String getEncryptedPwd = getSHA512(pwd);
		try {
			pstmt = conn.prepareStatement(selectAllByIdSQL);
			pstmt.setString(1, id);
			pstmt.setString(2, getEncryptedPwd);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String username = rs.getString("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String zipcode = rs.getString("zipcode");
				String address1 = rs.getString("address1");
				String address2 = rs.getString("address2");
				Timestamp joinDate = rs.getTimestamp("join_date");
				System.out.println(username + ":" + name + ":" + phone + ":" + email + ":" + zipcode + ":" + address1
						+ ":" + address2 + ":" + joinDate);
				userInfo = new UserDTO(username, name, phone, email, zipcode, address1, address2, joinDate);
				System.out.println(userInfo.getName());
				return userInfo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;

	}
	
	public int deleteById(String id) {
		int result = 0;
		String deleteByIdSQL = "delete from members where id = ?";
		try {
			pstmt = conn.prepareStatement(deleteByIdSQL);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int updateUserInfo(String id, UserDTO userInfo) {
		int result = 0;
		String updateUserInfoSQL = "update members set name = ?, phone=?, email=?, zipcode=?, address1=?, address2=? where id=? ";
		try (PreparedStatement pstmt= conn.prepareStatement(updateUserInfoSQL);){
			pstmt.setString(1, userInfo.getName());
			pstmt.setString(2, userInfo.getPhone());
			pstmt.setString(3, userInfo.getEmail());
			pstmt.setString(4, userInfo.getZipcode());
			pstmt.setString(5, userInfo.getAddress1());
			pstmt.setString(6, userInfo.getAddress2());
			pstmt.setString(7, id);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
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
