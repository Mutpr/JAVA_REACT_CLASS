package week1_0327;

import java.io.IOException;

public class Exam2 {
	public static void main(String [] args) throws IOException{
		System.out.println("한글자를 입력해주세요.");
		int num = System.in.read();
		
		System.out.println("입력하신 문자의 ASCII 코드 10진수는 "+num +"입니다.");
	}


}