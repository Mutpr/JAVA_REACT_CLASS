package basic_03_Movie_Quiz01;

import java.util.ArrayList;

public abstract class DAO {
	public abstract int insert(String insertSQL, int id,String title, String genre);
	public abstract int delete(String deleteSQL, int id);
	public abstract ArrayList<Object> read(String readSQL);
	public abstract int update(String updateSQL);
}
