package week1_0327;

import java.util.Scanner;

public class condition_quiz3 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		try {
			int number = Integer.parseInt(line);
			if(number >= 1 && number <= 100) {
				if(number%2 == 0) {
					System.out.println("짝수입니다.");
				}else if(number%2 == 1) {
					System.out.println("홀수입니다.");
				}
			}
		}catch(Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
}
