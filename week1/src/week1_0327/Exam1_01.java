package week1_0327;
import java.util.Scanner;

public class Exam1_01 {
	public static void main(String [] args) {
		System.out.println("1부터 10사이의 숫자를 입력해주세요.");
		Scanner sc= new Scanner(System.in);
		String str = sc.nextLine();
		try {
			int number = Integer.parseInt(str);
			if(number>=1 && number<=10) {
				System.out.println("통과! 통과!");
			}else if(number>10) {
				System.out.println("범위 초과!!");
			}
		}catch(Exception e) {
			System.out.println("잘못된 입력입니다");
		}
		
	}
}
