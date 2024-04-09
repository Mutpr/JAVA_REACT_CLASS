package main;

import java.util.Scanner;

import classes.Silver;
import dao.MemberManager;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MemberManager manager = new MemberManager();

		while (true) {
			System.out.println("<< 회원 관리 시스템 >>");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 목록 출력");
			System.out.println("0. 시스템 종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {

				System.out.print("ID : ");
				String id = sc.nextLine();

				System.out.print("Name : ");
				String name = sc.nextLine();

				System.out.print("Point : ");
				int point = Integer.parseInt(sc.nextLine());

				Silver s = new Silver(id, name, point);
				
//				manager.addMember(s);
//
//			} else if (menu == 2) {
//
//				Silver[] members = manager.getMembers();
//				System.out.println("ID\tName\tPoint\tBonus");
//				for (int i = 0; i < manager.getIndex(); i++) {
//					System.out.println(members[i].getId() + "\t" + members[i].getName() + "\t" + members[i].getPoint()
//							+ "\t" + members[i].getBonus());
//				}

			} else if (menu == 0) {
				System.out.println("시스템 종료");
				System.exit(0);
			} else {
				System.out.println("메뉴를 다시 확인해주세요.");
			}
		}

	}
}
