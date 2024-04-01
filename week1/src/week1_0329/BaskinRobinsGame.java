package week1_0329;

import java.util.Scanner;

public class BaskinRobinsGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int countNumber = 0;
		System.out.println("======배스킨라빈스 게임을 시작합니다.======");
		while (true) {
			int randomNumber = (int) (Math.random() * 3) + 1;
			System.out.print("자신이 입력할 갯수를 입력하세요.>>");
			String selectCount = sc.nextLine();
			try {
				if (countNumber == 31) {
					System.out.println("게임을 종료합니다!");
					System.exit(0);
				}
				int count = Integer.parseInt(selectCount);
				switch (count) {
				case 1:
					countNumber++;
					System.out.print(countNumber + "\n");
					System.out.println("컴퓨터가 선택한 난수는=>" + randomNumber + " 입니다.");
					for (int i = 1; i <= randomNumber; i++) {
						countNumber++;
						System.out.println(countNumber + "\t");
					}
					continue;
				case 2:
					for (int i = 1; i <= 2; i++) {
						countNumber++;
						System.out.print(countNumber + "\n");
					}
					System.out.println("컴퓨터가 선택한 난수는=>" + randomNumber + " 입니다.");
					for (int i = 1; i <= randomNumber; i++) {
						countNumber++;
						System.out.println(countNumber + "\t");
					}
					continue;
				case 3:
					for (int i = 1; i <= 3; i++) {
						countNumber++;
						System.out.print(countNumber + "\n");
					}
					System.out.println("컴퓨터가 선택한 난수는=>" + randomNumber + " 입니다.");
					for (int i = 1; i <= randomNumber; i++) {
						countNumber++;
						System.out.println(countNumber + "\t");
					}
					continue;
				}

			} catch (Exception e) {

			}
		}
	}

}
