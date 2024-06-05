package DAO;

import java.util.List;

import DTO.MessagesDTO;

public interface DAO {
	public abstract int insert();
	public abstract int delete(int id);
	public abstract List<MessagesDTO> selectAll();
	public abstract MessagesDTO selectOneById(int id);
	
}
