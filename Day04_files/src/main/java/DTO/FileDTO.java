package DTO;

public class FileDTO {
	private int seq;
	private String oriname;
	private String sysname;
	private int parent_seq;
	
	public FileDTO() {
		super();
	}
	
	public FileDTO(int seq, String oriname, String sysname, int parent_seq) {
		this.seq = seq;
		this.oriname = oriname;
		this.sysname = sysname;
		this.parent_seq = parent_seq;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	public String getSysname() {
		return sysname;
	}
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
}
