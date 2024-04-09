package week3_0409_Melon;

public class Melon {
	private int id;
	private String title;
	private String singer;
	private String author;
	private String date;
	
	public Melon() {
		super();
	}
	public Melon(int id,String title, String singer, String author) {
		this.id = id;
		this.singer = singer;
		this.author = author;
		this.title = title;
	}
	public Melon(String title, String singer, String author) {
		this.singer = singer;
		this.author = author;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
//	public String getDate() {
//		return date;
//	}
//	public void setDate(String date) {
//		this.date = date;
//	}
	
	

}
