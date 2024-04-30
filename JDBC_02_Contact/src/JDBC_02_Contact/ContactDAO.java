package JDBC_02_Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ContactDAO {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "KH";
	String pw = "KH";

	public Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(url, id, pw);
		return con;
	}

	// 신규등록
	public void insertContact(String name, String phone) throws SQLException {
		try (Connection con = this.getConnection(); Statement stmt = con.createStatement();) {
			if (isWrongContact(phone) == true) {
				// 중복값 검사
				String duplicationSQL = "select * from contact where name ='" + name + "'";
				ResultSet duplication = stmt.executeQuery(duplicationSQL);
				if (duplication.next()) {
					System.out.println("중복값입니다.");
				} else {
					String sql = "insert into contact values (contact_seq.nextval,'" + name + "','" + phone + "')";
					int rs = stmt.executeUpdate(sql);
					if (rs > 0) {
						System.out.println("입력 성공");
						duplication.close();
					} else {
						System.out.println("입력 실패");
					}
				}
			} else if(isWrongContact(phone) == false){
				System.out.println("옳지 않은 번호입니다.");
			}
		}

	}



	// 목록출력
	public ArrayList<ContactDTO> selectAllContactList() throws SQLException {
		ArrayList<ContactDTO> contactList = new ArrayList<ContactDTO>();
		try (Connection con = this.getConnection(); Statement stmt = con.createStatement();) {
			String selectAllSQL = "select * from contact";
			ResultSet selectAllResult = stmt.executeQuery(selectAllSQL);
			while (selectAllResult.next()) {
				int id = selectAllResult.getInt("id");
				String name = selectAllResult.getString("name");
				String phone = selectAllResult.getString("phone");
				ContactDTO contact = new ContactDTO(id, name, phone);
				contactList.add(contact);
			}
			selectAllResult.close();
			return contactList;
		}
	}

	// 항목 삭제
	public int deleteById(int deletionId) throws SQLException {
		try (Connection con = this.getConnection(); Statement stmt = con.createStatement();) {
			String deletionSQL = "delete from contact where id =" + deletionId;
			int deleteByIdResult = stmt.executeUpdate(deletionSQL);
			return deleteByIdResult;
		}
	}
	
	// 항목 수정
	public int updateMenu(int updatedId, String updatedName, String updatedContact) throws SQLException {
		try (Connection con = this.getConnection(); Statement stmt = con.createStatement();) {
			//있는 아이디의 항목인지 확인하기
			String selectOneByIdSQL = "select * from contact where id =" + updatedId;
			ResultSet selectOneById = stmt.executeQuery(selectOneByIdSQL);
			while(selectOneById.next()) {
				if (isWrongContact(updatedContact) == false && isDuplicated(updatedContact, updatedName) == false) {
					String updateSQL = "update contact set name = '" + updatedName + "', phone = '" + updatedContact
							+ "' where id = '"+updatedId+"'";
				int deleteByIdResult = stmt.executeUpdate(updateSQL);
				return deleteByIdResult;
			}
			// 중복값, 번호 유효성 검사
			
			}return 3;
		}
	}

	// 항목 검색(이름으로 검색)
	public ContactDTO selectOneByName(String selectedName) throws SQLException {
		ContactDTO contact = new ContactDTO();
		try (Connection con = this.getConnection(); Statement stmt = con.createStatement();) {
			String selectOneSQL = "select * from contact where name = '" + selectedName + "'";
			ResultSet selectOneResult = stmt.executeQuery(selectOneSQL);
			while (selectOneResult.next()) {
				contact.setId(selectOneResult.getInt("id"));
				contact.setName(selectOneResult.getString("Name"));
				contact.setPhone(selectOneResult.getString("phone"));
			}
			return contact;
		}
	}
	// 유효성 검사
	public boolean isWrongContact(String phone) {
		String[] numberArray = phone.split("-");
		System.out.println(numberArray.length);
		for(String array : numberArray) {
			System.out.print(array+"/");
		}
		if (!numberArray[0].equals("010") || numberArray[1].length() != 4 || numberArray[2].length() != 4) {
			return true;
		} else {
			return false;
		}
	}

	// 중복검사
	public boolean isDuplicated(String phone, String name) throws SQLException {
		try (Connection con = this.getConnection(); Statement stmt = con.createStatement();) {
			String isDuplicatedSQL = "select * from contact where phone='" + phone + "' or name='" + name + "'";
			if (stmt.executeQuery(isDuplicatedSQL).next()) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public boolean isWrongId (int id) throws SQLException {
		try (Connection con = this.getConnection(); Statement stmt = con.createStatement();) {
			String selectOneSQL = "Select * from contact where id = '" + id + "'";
			ResultSet selectOneResult = stmt.executeQuery(selectOneSQL);
			if(selectOneResult.next() == true) {
				return false;
			}return true;
		}
	}
}