package DTO;

import java.sql.Timestamp;

public class ReplyDTO {
	private int seq;
	private String writer;
	private String contents;
	private Timestamp writer_date;
	private int parent_seq;
	
	public ReplyDTO() {
		super();
	}
	
	public ReplyDTO(int seq, String writer, String contents, Timestamp writer_date, int parent_seq  ) {
		this.seq=seq;
		this.writer=writer;
		this.contents = contents;
		this.writer_date = writer_date;
		this.parent_seq=parent_seq;
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

	public Timestamp getWriter_date() {
		return writer_date;
	}

	public void setWriter_date(Timestamp writer_date) {
		this.writer_date = writer_date;
	}

	public int getParent_seq() {
		return parent_seq;
	}

	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	
}
