package week2_0404_Quiz03;

public class Movie {
	private String platform;
	private String title;
	private String Genre;
	
	public Movie(String platform, String title, String Genre) {
		this.Genre = Genre;
		this.platform = platform;
		this.title = title;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}
	
}
