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
		menu: while (true) {
			System.out.print(view.menuPrint());
			String menuSelect = sc.nextLine();
			try {
				int menu = Integer.parseInt(menuSelect);
				int index = manager.returnIndex();
				Contact[] contactList;
				if (menu == 1) {
					System.out.println(index);
					insertion: while (true) {
						System.out.println("이름을 입력해주세요.");
						String user = sc.nextLine();
						userNameList[index] = user;
						System.out.println("번호를 입력해주세요.");
						String number = sc.nextLine();
						userNumberList[index] = number;

						if (duplicationValid(userNameList, userNumberList, index) == true
								|| contactNumberValid(number, numberVerification) == true) {
							System.out.println("잘못된 입력입니다.");
						} else if (duplicationValid(userNameList, userNumberList, index) != true
								&& contactNumberValid(number, numberVerification) != true) {
							manager.addContactList(new Contact(index, user, number));
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
					contactList = manager.getContactList();
					for (int i = 0; i < index; i++) {
						if (contactList[i] != null) {
							System.out.println(contactList[i].getId());
							System.out.println(contactList[i].getName());
							System.out.println(contactList[i].getPhone());
						}
					}
				} else if (menu == 3) {
					contactList = manager.getContactList();
					System.out.println(view.searchMenuPrint());

					String search = sc.nextLine();
					for (int i = 0; i < index; i++) {
						if (contactList[i] != null) { // 요소가 null이 아닌 경우에만 처리
							if (contactList[i].getName().equals(search)) {
								System.out.println(contactList[i].getName());
								System.out.println(contactList[i].getPhone());
							} else if (contactList[i].getPhone().equals(search)) {
								System.out.println(contactList[i].getName());
								System.out.println(contactList[i].getPhone());
							}
						}
					}
				} else if (menu == 4) {
					System.out.println("수정하려는 주소록의 이름 또는 번호를 입력해주세요.");
					contactList = manager.getContactList();

					String search = sc.nextLine();
					for (int i = 0; i < index; i++) {
						if (contactList[i].getName().equals(search)) {
							System.out.println("새로운 이름을 입력해주세요.");
							String updatedName = sc.nextLine();
							System.out.println("새로운 번호를 입력해주세요.");
							String updatedContact = sc.nextLine();
							contactList[i] = manager.updateContactList(index, updatedName, updatedContact);
							System.out.println(manager.getContactListAsIndex(index).getName());
						} else if (contactList[i].getPhone().equals(search)) {
							System.out.println("새로운 이름을 입력해주세요.");
							String updatedName = sc.nextLine();
							System.out.println("새로운 번호를 입력해주세요.");
							String updatedContact = sc.nextLine();
							contactList[i] = manager.updateContactList(index, updatedName, updatedContact);
							System.out.println(manager.getContactListAsIndex(index).getName());
						}
					}

				}

				else if (menu == 5) {
					contactList = manager.getContactList();
					System.out.println("삭제할 번호 또는 이름을 입력하세요");
					String deletedInfo = sc.nextLine();
					boolean deleted = false; // 삭제 여부를 확인하기 위한 변수
					for (int i = 0; i < index + 1; i++) {
						if (contactList[i] != null && (contactList[i].getName().equals(deletedInfo)
								|| contactList[i].getPhone().equals(deletedInfo))) {
							// 삭제할 요소를 찾았을 때
							// 삭제되는 요소를 null로 처리
							contactList[i] = null;
							// 삭제됨을 표시
							deleted = true;
							// 인덱스 감소
							index--;
							// 반복문 종료
							break;
						}
					}
					if (deleted) {
						System.out.println("삭제되었습니다.");
					} else {
						System.out.println("삭제할 요소를 찾을 수 없습니다.");
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

	public static boolean duplicationValid(String[] userNameList, String[] userNumberList, int index) {
		for (int i = 0; i < index + 1; i++) {
			for (int j = 0; j < i; j++) {
				if (userNameList[i].equals(userNameList[j]) == true
						|| userNumberList[i].equals(userNumberList[j]) == true) {
					System.out.println("중복입니다.");
					index--;
					return true;
				} else {
					return false;
				}
			}

		}
		return false;
	}

	public static boolean contactNumberValid(String contactNumber, String[] numberVerification) {
		numberVerification = contactNumber.split("-");
		if (numberVerification[0].equals("010") && numberVerification[0].length() == 3
				&& numberVerification[1].length() == 4 && numberVerification[2].length() == 4) {
			return false;
		} else {
			return true;
		}
	}
}
