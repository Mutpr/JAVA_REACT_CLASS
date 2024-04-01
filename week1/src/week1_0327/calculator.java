package week1_0327;

import java.util.Scanner;

public class calculator {
	public static void main(String[] args) {
		// 문자열 또는 큰 숫자를 입력받는 방법
		while (true) {
			System.out.println("=======================================");
			System.out.println("안녕하세요, 사용자님. 간단한 계산기 프로그램입니다.");
			System.out.println("원하시는 연산자를 입력해주세요.(+,-,*,/)");
			System.out.println("종료를 원하시면 q를 입력해주세요.");
			System.out.println("=======================================");
			Scanner sc = new Scanner(System.in);
			// 문자열을 입력받기 위해서 필요한 라이브러리 도구
			String str = sc.nextLine();
			try {
				int selection = 0;
				if (str.equals("+")) {
					selection = 1;
				} else if (str.equals("-")) {
					selection = 2;
				} else if (str.equals("*")) {
					selection = 3;
				} else if (str.equals("/")) {
					selection = 4;
				}else if(str.equals("q")) {
					selection = 5;
				}
				switch (selection) {
				case 1:
					System.out.println("더할 두개의 숫자를 입력해주세요.");
					int a1 = sc.nextInt();
					int b1 = sc.nextInt();
					int answer1 = plus(a1, b1);
					
					System.out.println("결과는 " + answer1 + " 입니다.");
					System.out.println("=======================================");
					System.out.println("** 초기화면으로 돌아갑니다. **");
					System.out.println("=======================================");
					continue;
				case 2:
					System.out.println("뺄 두개의 숫자를 입력해주세요.");
					int a2 = sc.nextInt();
					int b2 = sc.nextInt();
					int answer2 = minus(a2, b2);
					
					System.out.println("결과는 " + answer2 + " 입니다.");
					System.out.println("=======================================");
					System.out.println("** 초기화면으로 돌아갑니다. **");
					System.out.println("=======================================");
					continue;
				case 3:
					System.out.println("곱할 두개의 숫자를 입력해주세요.");
					int a3 = sc.nextInt();
					int b3 = sc.nextInt();
					int answer3 = square(a3, b3);
					
					System.out.println("결과는 " + answer3 + " 입니다.");
					System.out.println("=======================================");
					System.out.println("** 초기화면으로 돌아갑니다. **");
					System.out.println("=======================================");
					continue;
				case 4:
					System.out.println("나눌 두개의 숫자를 입력해주세요.");
					int a4 = sc.nextInt();
					int b4 = sc.nextInt();
					double answer4 = division(a4, b4);
					System.out.println("결과는 " + answer4 + " 입니다.");
					System.out.println("=======================================");
					System.out.println("** 초기화면으로 돌아갑니다. **");
					System.out.println("=======================================");
					continue;
				case 5:
					System.out.println("=======================================");
					System.out.println("** 시스템을 종료합니다. Have a nice day. **");
					System.out.println("=======================================");
					System.exit(0);
				default:
					System.out.println("보기에 있는 연산자를 입력하세요.");
					System.out.println("=======================================");
					System.out.println("** 시스템을 종료합니다. **");
					System.out.println("=======================================");
					System.exit(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	public static int plus(int a, int b) {
		int answer = a + b;
		return answer;
	}

	public static int minus(int a, int b) {
		int answer = a - b;
		return answer;
	}

	public static int square(int a, int b) {
		int answer = a * b;
		return answer;
	}

	public static double division(double a, double b) {
		double answer = a / b;
		return answer;
	}
}
