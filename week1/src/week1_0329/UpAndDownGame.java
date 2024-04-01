package week1_0329;

import java.util.Scanner;

public class UpAndDownGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int playerOneGameCount = 0;
		//player 1의 게임 횟수 측정
		int playerTwoGameCount = 0;
		//player 2의 게임 횟수 측정
		int player = 1;
		while (true) {
			//게임 자체를 반복해서 하기 위한 무한 루프문
			int number = (int) (Math.random() * 100) + 1;
			//랜덤한 숫자 가져오기
			System.out.println("== up & down Game ==");
			System.out.println("1. Game Start ");
			System.out.println("2. Game Score ");
			System.out.println("3. End Game ");
			System.out.print(" >>");
			String menu = sc.nextLine();
			//메뉴를 선택하기 위한 입력문
			try {
				System.out.println("<<Game Start>>");
				int menuSelect = Integer.parseInt(menu);
				switch (menuSelect) {
				case 1:
					while (true) {
						//숫자 입력을 무한하게 하기 위한 루프문
						if (player == 1) {
							//만약 플레이어의 숫자가 1이라면
							System.out.print("플레이어 1 Input Number >>");
							String numberSelect = sc.nextLine();
							//게임중 숫자를 입력하기 위한 입력문
							try {
								int selectedNumber = Integer.parseInt(numberSelect);
								if (selectedNumber == number) {
									System.out.println("정답입니다! 숫자는 " + number + " 이었습니다!!!!!");
									System.out.println(playerOneGameCount);
									//맞고 틀리는 것과 관계없이 +1 해서 player를 2로 바꿔주도록
									break;
								} else {
									if (number < selectedNumber) {
										//내가 선택한 숫자가 제시된 숫자보다 큰 숫자라면
										System.out.println("down!");
										//down을 출력하고
										playerOneGameCount += 1;
										//틀렸으므로 게임 카운트를 +1 시켜주고
										player++;
										//플레이어 2로 이동
									} else if (number > selectedNumber) {
										//작은 숫자라면
										System.out.println("up!");
										//up을 출력
										playerOneGameCount += 1;
										//틀렸으므로 게임 카운트 +1 시켜주고 플레이어 2로 이동 
										player++;
									}
								}

							} catch (Exception e) {
								System.out.println("숫자를 입력하세요~!");
							}
						} else if (player == 2) {
							System.out.print(" 플레이어 2 Input Number >>");
							String numberSelect = sc.nextLine();
							try {
								int selectedNumber = Integer.parseInt(numberSelect);
								if (selectedNumber == number) {
									System.out.println("정답입니다! 숫자는 " + number + " 이었습니다!!!!!");
									System.out.println(playerTwoGameCount);
									break;
								} else {
									if (number < selectedNumber) {
										System.out.println("down!");
										playerTwoGameCount += 1;
										player--;
										/*
										 * 제시한 숫자가 컴퓨터가 선택한 숫자보다 크므로 down 출력 후
										 * 플레이어 1로 이동해야 하므로 여기서는 player를 경감해서 2에서 1로 이동시킴
										 */
									} else if (number > selectedNumber) {
										System.out.println("up!");
										playerTwoGameCount += 1;
										player--;
										/*
										 * 제시한 숫자가 컴퓨터가 선택한 숫자보다 작으므로 up 출력 후
										 * 플레이어 1로 이동해야 하므로 여기서는 player를 경감해서 2에서 1로 이동시킴
										 */
									}
								}

							} catch (Exception e) {
								System.out.println("숫자를 입력하세요~!");
							}
						}

					}
				case 2:
					//플레이어의 총 도전 횟수를 출력해줌
					System.out.println("플레이어 1 님의 총 도전 횟수는" + playerOneGameCount + " 번 입니다.");
					System.out.println("플레이어 2 님의 총 도전 횟수는" + playerTwoGameCount + " 번 입니다.");
					continue;
				case 3:
					//게임 종료
					System.out.println("==== GoodBye. ====");
					System.exit(0);
				default:
					System.out.println("잘못된 입력입니다~");
				}
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다~");

			}
		}

	}
}
