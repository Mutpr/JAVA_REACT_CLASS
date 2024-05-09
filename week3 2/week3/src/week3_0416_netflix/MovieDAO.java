package week3_0416_netflix;

import java.util.ArrayList;

public class MovieDAO {
	private int index = 0;
	private ArrayList<MovieDTO> movieList = new ArrayList<MovieDTO>();

	public ArrayList<MovieDTO> getMovies() {
		return movieList;
	}

	public void addMovies(String title, int id, String genre, String date) {
		MovieDTO movie = new MovieDTO(id, title, genre, date);
		//id = index
		//아무거나..
		movieList.add(movie);
	}

	public ArrayList<MovieDTO> deleteMovies(int id) {
		for (int i=0; i<movieList.size(); i++) {
			System.out.println(movieList.get(i).getId());
			System.out.println(id);
			if (movieList.get(i).getId() == id) {
				movieList.remove(i);
			}
		}
		return movieList;
	}

	public MovieDTO searchMovies(String title) {
		for(int i=0; i<movieList.size(); i++) {
			if(movieList.get(i).getTitle().equals(title)) {
				System.out.println("생성일자"+movieList.get(i).getDate());
				return movieList.get(i);
			}
		}
		return null;
	}

	public void updateMovieList(MovieDTO updatedMovie, int index) {
		for(int i=0; i<movieList.size(); i++) {
			if(movieList.get(i).getId()==index) {
				System.out.println("생성일자"+movieList.get(i).getDate());
				movieList.set(index, updatedMovie);
			}
		}
	}
	
	public int indexReturn() {
		return index;
	}
}