package JDBC_02_Contact;

import java.util.List;
import java.util.Scanner;

public class ContactMain {
	public static void main(String[] args) {
		ContactDAO manager = new ContactDAO();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("1. 신규 등록 2. 목록 출력 3. 항목 삭제(id로 삭제)4. 항목 수정(id로 삭제) 5. 항목 검색(이름으로 검색) 0. 종료");
			int menuSelect = Integer.parseInt(sc.nextLine());
			try {
				if (menuSelect == 1) {
					insertion: while (true) {
						System.out.print("이름 입력");
						String name = sc.nextLine();
						System.out.print("번호 입력");
						String phone = sc.nextLine();
						manager.insertContact(name, phone);
						System.out.print("입력을 종료하시려면 0번을, 입력을 계속하시려면 1번을 선택해주세요.");
						int overSign = Integer.parseInt(sc.nextLine());
						try {
							if (overSign == 1) {
								continue insertion;
							} else if (overSign == 0) {
								System.out.println("입력을 종료합니다.");
								break insertion;
							} else {
								break insertion;
							}
						} catch (Exception e) {
							System.out.println("overSign ::  잘못된 입력입니다.");
							e.printStackTrace();
						}
					}
				}

				// 목록출력
				if (menuSelect == 2) {
					System.out.println("전체 목록 출력");
					List<ContactDTO> contactList = manager.selectAllContactList();
					for (ContactDTO contact : contactList) {
						System.out.print("아이디: " + contact.getId() + "\t");
						System.out.print("이름: " + contact.getName() + "\t");
						System.out.print("연락처: " + contact.getPhone() + "\n");
					}
				}

				// 항목삭제(아이디로 삭제)
				if (menuSelect == 3) {
					System.out.println("전체 목록 출력");
					int deletedId = Integer.parseInt(sc.nextLine());
					if (manager.deleteById(deletedId) > 0) {
						System.out.println(deletedId + " 번 아이디 삭제되었습니다.");
					} else {
						System.out.println("삭제 실패");
					}
				}

				// 항목수정(아이디로 수정)
				if (menuSelect == 4) {
					System.out.println("항목 수정");
					try {
						System.out.println("수정하고자 하는 아이디를 입력하세요.");
						int updatedId = Integer.parseInt(sc.nextLine());
						if (manager.isWrongId(updatedId) == true) {
							System.out.println("잘못된 아이디입니다.");
						} else {
							System.out.println("수정하고자 하는 이름을 입력하세요.");
							String updatedName = sc.nextLine();
							System.out.println("수정하고자 하는 연락처를 입력하세요.");
							String updatedPhone = sc.nextLine();
							manager.updateMenu(updatedId, updatedName, updatedPhone);
						}

					} catch (Exception e) {
						System.out.println("update :: 잘못된 입력입니다.");
						e.printStackTrace();
					}

				} // 항목검색(이름으로 검색)
				if (menuSelect == 5) {
					String selectedName = sc.nextLine();
					ContactDTO contact = manager.selectOneByName(selectedName);
					System.out.print("아이디: " + contact.getId() + "\t");
					System.out.print("이름: " + contact.getName() + "\t");
					System.out.print("연락처: " + contact.getPhone() + "\n");
				}
				if (menuSelect == 0) {
					System.out.print("시스템을 종료합니다.");
					System.exit(0);

				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.print("menu:: 잘못된 입력입니다.");

			}
		}
	}
}