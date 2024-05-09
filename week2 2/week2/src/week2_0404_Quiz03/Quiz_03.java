package week2_0404_Quiz03;

public class Quiz_03 {

	public static void main(String[] args) {
		Movie[] movies = new Movie[2];
		movies[0] = new Movie("netFlix", "범죄도시", "액");
		movies[1] = new Movie("메박", "파묘", "오컬트");
		
		System.out.println(movies[1].getTitle());
		
	}

}
