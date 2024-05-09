package week3;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentView view = new StudentView();
		StudentDAO dao = new StudentDAO();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print(view.menuPrint());
			String menuSelect = sc.nextLine();
			try {
				int menu = Integer.parseInt(menuSelect);
				if(menu == 1) {
					String select = sc.nextLine();
					try {
						int selectNm = Integer.parseInt(select);
						if(selectNm == 1) {
							System.out.println("");
						}else if(selectNm == 0) {
							System.out.println("입력을 종료합니다.");
						}else {
							System.out.println("1과 0 중에 선택해주세요.");
						}
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("잘못된 입력입니다.");
					}
				}else if(menu == 2) {
					
				}else if(menu == 3) {
					
				}else if(menu == 4) {
					
				}
			} catch(Exception e) {
				
			}
		}
	}

}
