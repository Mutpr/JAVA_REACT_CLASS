package week5_0429_Cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CafeDAO {

	ArrayList<CafeDTO> menuList = new ArrayList<CafeDTO>();
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "KH";
	String pw = "KH";

	// 여러개 한번에 입력
	public void insertMenu(String name, int price) throws SQLException {
		Connection con = DriverManager.getConnection(url, id, pw);
		Statement stmt = con.createStatement();
		String sql = "insert into cafe_menu values (cafe_menu_seq.nextval, '" + name + "','" + price + "')";

		int rs = stmt.executeUpdate(sql);
		if (rs > 0) {
			System.out.println("입력성공");
		} else {
			System.out.println("입력실패");
		}
		con.close();
	}

	// 삭제
	public void deleteMenu(int deletionId) throws SQLException {
		Connection con = DriverManager.getConnection(url, id, pw);
		Statement stmt = con.createStatement();
		CafeDTO menu = null;
		String sql = "delete from cafe_menu where id = " + deletionId;

		int rs = stmt.executeUpdate(sql);
		if (rs > 0) {
			System.out.println("삭제성공");
		} else {
			System.out.println("삭제실패");
		}
		con.close();
	}

// 수정
	public void updateMenu(int updatedId, String updatedMenu, int updatedPrice) throws SQLException {
		Connection con = DriverManager.getConnection(url, id, pw);
		Statement stmt = con.createStatement();
		String sql = "update cafe_menu set name = '" + updatedMenu + "', price = '" + updatedPrice + "' where id ='"
				+ updatedId + "'";
		int rs = stmt.executeUpdate(sql);
		if (rs > 0) {
			System.out.println("수정성공");
			String selectedSql = "select * from cafe_menu where id =" + updatedId;
			ResultSet selectedRS = stmt.executeQuery(selectedSql);
			while (selectedRS.next()) {
				System.out.println(selectedRS.getInt("id"));
				System.out.println(selectedRS.getString("name"));
				System.out.println(selectedRS.getInt("price") + "원");
			}
		} else {
			System.out.println("수정실패");
		}
		con.close();
	}

// 전체검색
	public ArrayList<CafeDTO> selectAll() throws SQLException {
		Connection con = DriverManager.getConnection(url, id, pw);
		Statement stmt = con.createStatement();

		String sql = "select * from cafe_menu";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			CafeDTO menu = new CafeDTO();
			menu.setId(rs.getInt("id"));
			menu.setMenu(rs.getString("name"));
			menu.setPrice(rs.getInt("price"));

			menuList.add(menu);
		}
		con.close();
		return menuList;

	}

// 일부검색
	public CafeDTO selectOneById(int selectedId) throws SQLException {
		Connection con = DriverManager.getConnection(url, id, pw);
		Statement stmt = con.createStatement();

		String sql = "select * from cafe_menu where id = " + selectedId;

		ResultSet rs = stmt.executeQuery(sql);
		CafeDTO cafeMenu = new CafeDTO();
		while (rs.next()) {
			cafeMenu.setId(selectedId);
			cafeMenu.setMenu(rs.getString("name"));
			cafeMenu.setPrice(rs.getInt("price"));
		}

		return cafeMenu;
	}
}