package week1_0327;

import java.util.Scanner;

public class Exam3_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("사용자의 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		System.out.print(name+" 님의 국어 점수를 입력해주세요.");
		String str1 = sc.nextLine();
		System.out.print(name+" 님의 영어 점수를 입력해주세요.");
		String str2 = sc.nextLine();
		System.out.print(name+" 님의 수학 점수를 입력해주세요.");
		String str3 = sc.nextLine();
		try {
			int korean = Integer.parseInt(str1);
			int english = Integer.parseInt(str2);
			int math = Integer.parseInt(str3);
			double average = (double)(korean+english+math)/3;
			int total = korean+english+math;
			System.out.println("이름: "+ name);
			System.out.println("============");
			System.out.println("국어: "+korean);
			System.out.println("영어: "+english);
			System.out.println("수학: "+math);
			System.out.println("============");
			System.out.println("합계: "+total);
			System.out.printf("평균: "+average);
		}catch(Exception e) {
			System.out.println("잘못된 입력입니다.");
		}
	}
}
