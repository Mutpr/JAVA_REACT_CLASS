package week1_0328;

import java.util.Scanner;

public class quiz5 {
	//구구구구구단
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("단수를 입력하세요.");
		int row = sc.nextInt();
		if(row<=1 || row>=10) { //0과 같거나 작으면, 10과 같거나 크면 잘못된 입
			System.out.println("잘못된 입력입니다.");
		} else if(row>=2 && row<=9) { //2단에서부터 9단까지라면 시작!
			int i = 1;
			while(i<9) { //부등호 방향 항상 체크!! 
				i++;
				System.out.println(row + " * "+i+" = "+(row*i));
			}
		}
	}
}