package week1_0328;

import java.util.Scanner;

public class VendingSimulator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 3000;
		int coke = 1200;
		int cokecnt = 0;
		int cider = 800;
		int cidercnt = 0;
		int plum = 1500;
		int plumcnt = 0;
		while(true) {
			System.out.println("=====자판기 시뮬레이터=====");
			System.out.println("1.콜라(1200) 2.사이다(800) 3.매실차(1500) [0.소지품확인]");
			System.out.print(">>");
			String menu = sc.nextLine();
			try {
				int vendingMenu = Integer.parseInt(menu);
				switch(vendingMenu) {
				case 1:
					if(money >= 1200) {
						money -= coke;
						System.out.println("소지금: -1200");
						cokecnt++;
						System.out.println("콜라 + 1");
					}else {
						System.out.println("잔액이 부족합니다.");
					}
					continue;
				case 2:
					if(money >= 800) {
						money -= 800;
						System.out.println("소지금: -800");
						cidercnt++;
						System.out.println("사이다 + 1");
					}else {
						System.out.println("잔액이 부족합니다.");
					}
					continue;
				case 3:
					if(money >= 1500) {
						money -= plum;
						System.out.println("소지금: -1500");
						plumcnt++;
						System.out.println("매실 + 1");
					}else {
						System.out.println("잔액이 부족합니다.");
					}continue;
				case 0:
					System.out.println("잔액: "+money);
					System.out.println("콜라 갯수: "+cokecnt);
					System.out.println("사이다 갯수: "+cidercnt);
					System.out.println("매실 갯수: "+plumcnt);
					break;
				}
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
					break;
				}
		}
		
		

	}

}