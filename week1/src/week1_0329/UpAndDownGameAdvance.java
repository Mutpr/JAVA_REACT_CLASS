
package week1_0329;

import java.util.*;

/*
 * 내가 플레이어 1이 되고 컴퓨터가 플레이어 2가 되어서
 * 컴퓨터도 숫자 하나를 랜덤하게 출력하고
 * 나도 입력해서 게임하도록
 * 근데 내가 입력한 하나의 숫자를 컴퓨터가 반영하게 만들기
 */
public class UpAndDownGameAdvance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int player = 1;
		int playerCount = 0;
		int playerSelectedNumber = 0;
		/*
		 * 컴퓨터가 난수를 생성할때 엉뚱한곳에서 난수를 가져오지 않도록 하기 위해 
		 * 먼저 변수를 생성해 숫자를 저장할 수 있도록 밖으로 빼 둠
		 */
		while (true) { // 게임 자체를 무한하게 진행하기 위한 루프문
			int number = (int) (Math.random() * 100) + 1;
			// 랜덤한 숫자 가져오기
			System.out.println("== up & down Game ==");
			System.out.println("1. Game Start ");
			System.out.println("2. Game Score ");
			System.out.println("3. End Game ");
			System.out.print(" >>");
			String menu = sc.nextLine();
			
				try {
					// 잘못된 입력이 들어오지 않았나 검사하는 try 문
					int menuSelect =Integer.parseInt(menu);
					switch (menuSelect) {
					case 1:
						game: while (true) {
							// player가 플레이 하는 경우
							System.out.print("숫자를 입력해주세요.>>");
							String select = sc.nextLine();
							try {
								int selectedNumber = Integer.parseInt(select);
								// 입력으로 받아오는 숫자 따로
								if (selectedNumber == number) {
									System.out.println("맞았습니다! 정답은 " + number + " 입니다.");
									System.out.println(playerCount + " 만에 맞추셨습니다.");
									break game;
									// 맞은 경우
								} else if (selectedNumber > number) {
									System.out.println("down!");
									playerCount++;
									player++;
									playerSelectedNumber = selectedNumber;
									System.out.println("playerSelectedNumber: "+playerSelectedNumber);
									// 따로 빼서 컴퓨터가 난수 생성할때 가지고 갈 수 있도록 대입
	
								} else if (selectedNumber < number) {
									System.out.println("up!");
									playerCount++;
									player++;
									playerSelectedNumber = selectedNumber;
								}
							} catch (Exception e) {
								// 숫자 선택시 잘못된 입력을 입력한 경우
								System.out.println("숫자를 입력하지 않으셨습니다.");
							}
							if (player == 2 && playerSelectedNumber > number) {
								System.out.println("컴퓨터 1 플레이 시작합니다.");
								int computerSelectedNumber = getDownNumber(playerSelectedNumber);
								System.out.println("컴퓨터 1가 뽑은 숫자는"+computerSelectedNumber+"입니다.");
								player--;
								
							}else if(player == 2 && playerSelectedNumber < number) {
								System.out.println("컴퓨터 1 플레이 시작합니다.");
								int computerSelectedNumber = getUpNumber(playerSelectedNumber);
								System.out.println("컴퓨터 1가 뽑은 숫자는"+computerSelectedNumber+"입니다.");
								if(computerSelectedNumber == number) {
									System.out.println("패배하셨습니다 ㅜㅜ ");
								}
								player--;
							}
							else if(player == 2) {
								int computerSelectedNumber = getUpNumber(playerSelectedNumber);
								System.out.println("컴퓨터 1가 뽑은 숫자는"+computerSelectedNumber+"입니다.");
								
							}
						}

					case 2:
					case 3:
					default:
					}
				} catch (Exception e) {
					// 메뉴 선택시 잘못된 입력을 입력 한 경우
					System.out.println();
				}
			}
		}

	
	public static int getDownNumber(int playerSelectedNumber) {
		int range = (playerSelectedNumber - 1) + 1;
		int random = (int) (Math.random()*playerSelectedNumber)+ 1;
		return random;
	}
	
	public static int getUpNumber(int playerSelectedNumber) {
		//playerSelectedUpNumber == max 값이되고 playerSelectedDownNumber==min값이 됨
		int random = (int)(Math.random()*100)+playerSelectedNumber;
		return random;
	}
}
