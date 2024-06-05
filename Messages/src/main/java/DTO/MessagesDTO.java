package DTO;

import java.sql.Timestamp;

public class MessagesDTO {
	private int id;
	private String message;
	private String author;
	private Timestamp reg_date;
	
	public MessagesDTO() {
		super();
	}
	
	public MessagesDTO(int id, String messages, String author, Timestamp reg_date) {
		this.id = id;
		this.message = messages;
		this.author = author;
		this.reg_date=reg_date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
}
