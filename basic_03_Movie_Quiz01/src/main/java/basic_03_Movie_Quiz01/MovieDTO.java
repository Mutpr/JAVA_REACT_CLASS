package basic_03_Movie_Quiz01;

public class MovieDTO {
	private int id;
	private String title;
	private String genre;
	private String date;
	
	public MovieDTO() {
		super();
	}
	public MovieDTO(int id, String title, String genre, String date) {
		this.id = id;
		this.title= title;
		this.genre = genre;
		this.date = date;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}