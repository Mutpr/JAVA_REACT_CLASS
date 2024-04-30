package week5_0429_Cafe;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CafeMain {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		CafeDAO manager = new CafeDAO();
		menu: while (true) {
			System.out.println("1. 입력 2. 수정 3. 삭제 4. 전체 메뉴 출력 5. 일부 메뉴 출력");
			int menuSelect = Integer.parseInt(sc.nextLine());
			// 입력
			if (menuSelect == 1) {
				insertion: while (true) {
					try {
						System.out.print("새로운 메뉴 이름>>");
						String menu = sc.nextLine();
						System.out.print("새로운 메뉴 가격>>");
						int price = Integer.parseInt(sc.nextLine());
						manager.insertMenu(menu, price);

						System.out.println("입력을 계속하시려면 1, 아니라면 0을 입력해주세요.");

						int overSign = Integer.parseInt(sc.nextLine());
						if (overSign == 1) {
							continue insertion;
						} else if (overSign == 0) {
							break insertion;
						} else {
							System.out.println("insertion : 잘못된 입력입니다.");
							break insertion;
						}
					} catch (Exception e) {
						System.out.println("menu : 잘못된 입력입니다.");
						continue menu;
					}
				}
				// 업데이트
			} else if (menuSelect == 2) {
				try {
					System.out.print("업데이트 하고자 하는 메뉴의 아이디를 입력하세요>>");
					int updatedId = Integer.parseInt(sc.nextLine());
					System.out.print("새로운 메뉴 이름>>");
					String updatedMenu = sc.nextLine();
					System.out.print("새로운 메뉴 가격>>");
					int updatedPrice = Integer.parseInt(sc.nextLine());
					manager.updateMenu(updatedId, updatedMenu, updatedPrice);

				} catch (Exception e) {
					System.out.println("menu : 잘못된 입력입니다.");
					e.printStackTrace();
				}
				// 삭제
			} else if (menuSelect == 3) {
				System.out.print("삭제하고자 하는 메뉴의 아이디를 입력하세요>>");
				int deletionId = Integer.parseInt(sc.nextLine());
				manager.deleteMenu(deletionId);
				// 전체출력
			} else if (menuSelect == 4) {
				ArrayList<CafeDTO> menuList = manager.selectAll();
				for(CafeDTO cafe: menuList) {
					System.out.println(cafe.getId());
					System.out.println(cafe.getMenu());
					System.out.println(cafe.getPrice());
				}
			}else if(menuSelect == 5) {
				System.out.print("검색 하고자 하는 메뉴의 아이디를 입력하세요>>");
				int selectedId = Integer.parseInt(sc.nextLine());
				CafeDTO selectedMenu = manager.selectOneById(selectedId);
				System.out.println(selectedMenu.getId());
				System.out.println(selectedMenu.getMenu());
				System.out.println(selectedMenu.getPrice());
			}

		}
	}

}