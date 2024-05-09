package week2_0404_OOP;

import java.io.FileInputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import javazoom.jl.player.Player;

public class Exam01 {

	public static void main(String[] args) {
		JButton btn = new JButton(">");
		JFrame jframe= new JFrame();
		jframe.add(btn);
		jframe.setVisible(true);
		
		//뮤직 플레이 기능 만들기
		Scanner sc = new Scanner(System.in);
	    FileInputStream fis;
		try {
			fis = new FileInputStream("abc.mp3");
		    Player playMP3 = new Player(fis);
		    playMP3.play();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
