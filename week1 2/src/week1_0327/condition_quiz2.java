package week1_0327;

import java.util.Scanner;

public class condition_quiz2 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자 입력:");
		String line1 = sc.nextLine();
		try {
			int number1 = Integer.parseInt(line1);
			System.out.print("두번째 숫자 입력:");
			String line2 = sc.nextLine();
			int number2 = Integer.parseInt(line2);
			
			System.out.println("=========결과:=========");
			if(number1>number2) {
				System.out.println("첫 번째 숫자가 두 번째 숫자보다 큽니다.");
			}else if(number2>number1) {
				System.out.println("두 번째 숫자가 첫 번째 숫자보다 큽니다.");
			}else if(number1 == number2) {
				System.out.println("서로 다른 숫자를 입력하세요.");
			}
		}catch(Exception e) {
			System.out.println("잘못된 입력입니다.");
		}
	}
}