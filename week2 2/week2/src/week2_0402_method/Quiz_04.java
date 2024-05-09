package week2_0402_method;

import java.util.Scanner;

public class Quiz_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String operator = sc.nextLine();
		System.out.println();
		while(true) {
			if(validOperator(operator) == false) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
		}
		
	}
	
	public static boolean validOperator(String str) {
		if(str.equals("+")||str.equals("-")||str.equals("%")||str.equals("/")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean validInput(String input) {
		if(input.getClass().getName().equals("java.lang.String")) {
			System.out.println("잘못된 입력입니다.");
			return false;
		}else if(input.getClass().getName().equals("java.lang.Integer")) {
			
		}
		return true;
	}

}
