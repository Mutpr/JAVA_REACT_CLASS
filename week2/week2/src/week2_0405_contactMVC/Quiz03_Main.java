package week2_0405_contactMVC;

import java.util.Scanner;

public class Quiz03_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ContactView view = new ContactView();
		ContactManager manager = new ContactManager();
		// 메뉴 출력

		String[] userNameList = new String[100];
		String[] userNumberList = new String[100];

		String[] numberVerification = new String[3];
		while (true) {
			System.out.print(view.menuPrint());
			String menuSelect = sc.nextLine();
			try {
				int menu = Integer.parseInt(menuSelect);
				int index = manager.returnIndex();
				if (menu == 1) {
					System.out.println(index);
					insertion: while (true) {
						System.out.println("이름을 입력해주세요.");
						String user = sc.nextLine();
						userNameList[index] = user;
						System.out.println("번호를 입력해주세요.");
						String number = sc.nextLine();
						userNumberList[index] = number;
						numberVerification = number.split("-");
						if (numberVerification[0].equals("010") && numberVerification[0].length() == 3
								&& numberVerification[1].length() == 4 && numberVerification[2].length() == 4) {
							manager.addContactList(new Contact(index, user, number));
						} else {
							System.out.println("잘못된 번호입니다.");
							// 잘못된 번호 입력시 배열 초기화하는 코드 필요함!!
							index--;
							continue;
						}

						for (int i = 0; i < index + 1; i++) {
							for (int j = 0; j < i; j++) {
								if (userNameList[i].equals(userNameList[j]) == true
										|| userNumberList[i].equals(userNumberList[j]) == true) {
									System.out.println("중복입니다.");
									index--;
									continue insertion;
								}
							}

						}

						System.out.println("입력을 계속하시려면 1번을, 종료하려면 0번을 눌러주세요.");
						String overSignal = sc.nextLine();
						try {
							int over = Integer.parseInt(overSignal);
							if (over == 1) {
								index++;
								continue insertion;
							} else if (over == 0) {
								break insertion;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				} else if (menu == 2) {
					Contact[] contactList = manager.getContactList();
					for (int i = 0; i < index; i++) {
						System.out.println(contactList[i].getId());
						System.out.println(contactList[i].getName());
						System.out.println(contactList[i].getPhone());
					}

				} else if (menu == 3) {
					Contact[] contactList = manager.getContactList();
					System.out.println(view.searchMenuPrint());

					String search = sc.nextLine();
					for (int i = 0; i < index; i++) {
						if (contactList[i].getName().equals(search)) {
							System.out.println(contactList[i]);
						} else if (contactList[i].getPhone().equals(search)) {
							System.out.println(contactList[i]);
						}
					}
				} else if (menu == 4) {
					System.out.println("새로운 이름을 입력해주세요.");
					String updatedUser = sc.nextLine();
					System.out.println("새로운 번호를 입력해주세요.");
					String updatedNumber = sc.nextLine();
					manager.updateContactList(new Contact(index, updatedUser, updatedNumber));
				} else if (menu == 5) {
					Contact [] contactList = manager.getContactList();
					System.out.println("삭제할 번호 또는 이름을 입력하세요");
					String deletedInfo = sc.nextLine();
					for(int i=0; i<index+1; i++) {
						if(contactList[i].getName().equals(deletedInfo) || contactList[i].getPhone().equals(deletedInfo)) {
							manager.deleteContactListAsArray(index);
							System.out.println("삭제되었습니다.");
						}
					}
				} else if (menu == 0) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("잘못된 메뉴 입력입니다.");
				e.printStackTrace();
			}
		}
	}

}
