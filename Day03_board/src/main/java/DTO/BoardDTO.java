package DTO;

import java.sql.Timestamp;

public class BoardDTO {

	private int seq;
	private String title;
	private String writer;
	private String contents;
	private Timestamp write_date;
	
	public BoardDTO() {
		super();
	}
	
	public BoardDTO(int seq, String writer, String contents, Timestamp write_date, String title) {
		this.seq=seq;
		this.writer=writer;
		this.contents=contents;
		this.write_date=write_date;
		this.title=title;
	}
	
	public BoardDTO(int seq, String writer, String contents, String title) {
		this.seq=seq;
		this.writer=writer;
		this.contents=contents;
		this.title=title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	
}
