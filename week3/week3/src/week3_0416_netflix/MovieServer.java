package week3_0416_netflix;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MovieServer {

	public static void main(String[] args) throws IOException {
		MovieDAO manager = new MovieDAO();

		MovieDTO movie;
		ServerSocket server = new ServerSocket(26000);
		Socket socket = server.accept();
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		System.out.println(socket.getInetAddress() + "/로부터 접속");
		
		int id = manager.indexReturn();
		while (true) {

			int msg = dis.readInt();
			System.out.println(msg);
			if (msg == 1) {
				dos.writeUTF("** 영화 입력 시스템 **");
				insertion: while (true) {
					dos.writeUTF("제목을 입력합니다.");
					dos.flush();
					String title = dis.readUTF();
					System.out.println(title);

					dos.writeUTF("장르를 입력합니다.");
					dos.flush();
					String genre = dis.readUTF();
					System.out.println(genre);
					
					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
					String time = formatter.format(date);
					manager.addMovies(title, id, genre, time);

					dos.writeUTF("입력을 계속하시려면 1을, 아니라면 0을 입력해주세요.");
					int overmsg = dis.readInt();
					if (overmsg == 1) {
						continue insertion;
					} else if (overmsg == 0) {
						break insertion;
					}
				}

			} else if (msg == 2) {
//				for (MovieDTO movie : manager.getMovies()) {

//					dos.writeUTF("아이디: " + movie.getId());
//					dos.writeUTF("제목: " + movie.getTitle());
//					dos.writeUTF("장르: " + movie.getGenre());
//					dos.writeUTF("날짜: " + movie.getDate());
//				}
				ArrayList<MovieDTO> movieList = manager.getMovies();
				int index = manager.indexReturn();
				dos.writeInt(index);
				for (int i = 0; i < index; i++) {
					movie = movieList.get(i);
					dos.writeUTF("아이디: " + movie.getId());
					dos.writeUTF("제목: " + movie.getTitle());
					dos.writeUTF("장르: " + movie.getGenre());
					dos.writeUTF("날짜: " + movie.getDate());
				}
				dos.flush();
			} else if (msg == 3) {
				String searchTitle = dis.readUTF();
				System.out.println(searchTitle);
				movie = manager.searchMovies(searchTitle);
				System.out.println(movie);
				System.out.println("아이디: " + movie.getId());
				System.out.println("제목: " + movie.getTitle());
				System.out.println("장르: " + movie.getGenre());
				System.out.println("날짜: " + movie.getDate());
				dos.writeUTF("아이디: " + movie.getId());
				dos.writeUTF("제목: " + movie.getTitle());
				dos.writeUTF("장르: " + movie.getGenre());
				dos.writeUTF("날짜: " + movie.getDate());
				dos.flush();
			} else if (msg == 4) {
				int deleteId = dis.readInt();
				manager.deleteMovies(deleteId);
			} else if (msg == 5) {
				int updatedId = dis.readInt();
				System.out.println(updatedId);
				String updatedTitle = dis.readUTF();

				System.out.println(updatedTitle);
				String updatedGenre = dis.readUTF();

				System.out.println(updatedGenre);
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
				String time = formatter.format(date);

				manager.updateMovieList(new MovieDTO(updatedId, updatedTitle, updatedGenre, time), updatedId);
			}
		}

	}

}
