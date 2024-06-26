package week1_0328;

import java.util.Scanner;

public class BankSimulator {

	public static void main(String[] args) {
		int won = 1000000;
		int password = 1234;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("=====================");
			System.out.println("은행 잔액조회 시스템 입니다.");
			System.out.println("=====================");
			System.out.println("1. 잔액조회");
			System.out.println("2. 입금하기");
			System.out.println("3. 출금하기");
			System.out.println("4. 종료하기");
			String menuSelect = sc.nextLine();
			try {
				int menuNumber = Integer.parseInt(menuSelect);
				if (menuNumber == 1) {
					System.out.println("현재 잔액은 " + won + " 원 입니다.");
					continue;
				} else if (menuNumber == 2) {
					System.out.print("입금 금액을 입력해주세요.>>");
					String deposit = sc.nextLine();
					try {
						int depositMoney = Integer.parseInt(deposit);
						won += depositMoney;
						System.out.println(depositMoney + "만큼 입금되었습니다.");
						continue;
					} catch (Exception e) {
						System.out.println("잘못된 입력입니다. 거래를 종료합니다.");
						break;
					}
				} else if (menuNumber == 3) {
					System.out.print("출금 금액을 입력해주세요. >>");
					String withdrawal = sc.nextLine();
					try {
						int withdrawalMoney = Integer.parseInt(withdrawal);
						if (withdrawalMoney > won) {
							System.out.println("가지고 있는 돈 보다 더 큰 금액을 출금할 수는 없습니다. 거래를 종료합니다.");
							break;
						} else {
							System.out.print("비밀번호를 입력해주세요. >>");
							String passwd = sc.nextLine();
							try {
								int passwordNumber = Integer.parseInt(passwd);
								if (password == passwordNumber) {
									won -= withdrawalMoney;
									System.out.println(withdrawalMoney + "만큼 출금되었습니다.");
									continue;
								} else if (password != passwordNumber) {
									System.out.println("비밀번호를 틀리셨습니다.");
									int tryCnt = 1;
									System.out.print("비밀번호를 입력해주세요. >>");
									System.out.println(tryCnt+ "번째 틀리셨습니다.");
									for(int i=1; i<3; i++) {
										int password1 = sc.nextInt();
										if(password != password1) {
											tryCnt++;
											System.out.println(tryCnt+ "번째 틀리셨습니다.");
											if(tryCnt==3) {
												System.out.println("비밀번호를 세번째 틀리셨으므로 거래가 취소됩니다.");
												System.exit(0);
											}
											
										}
										
										else if (password == passwordNumber) {
											won -= withdrawalMoney;
											System.out.println(withdrawalMoney + "만큼 출금되었습니다.");
											continue;
										}
									}
								}
								}
							catch (Exception e) {
								System.out.println("잘못된 입력입니다.");
								continue;
							}

						}

					} catch (Exception e) {
						System.out.println("잘못된 입력입니다. 거래를 종료합니다.");
						break;
					}
				} else if (menuNumber == 4) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				}
				else {
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
					continue;
				}
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				continue;
			}
		}

}

}
