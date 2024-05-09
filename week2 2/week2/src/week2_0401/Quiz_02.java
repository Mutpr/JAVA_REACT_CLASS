package week2_0401;

import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String student1[] = new String[3];
		String student2[] = new String[3];
		String student3[] = new String[3];
		
		System.out.print("첫번째 학생 이름>>");
		String studentOneName = sc.nextLine();
		student1[0] = studentOneName;
		System.out.print("첫번째 학생 국어점수>>");
		String studentOneKr = sc.nextLine();
		student1[1] = studentOneKr;
		System.out.print("첫번째 학생 영어점수>>");		
		String studentOneEn = sc.nextLine();
		student1[2] = studentOneEn;
		int studentOneAVG = (Integer.parseInt(studentOneKr)+Integer.parseInt(studentOneEn))/2;
		int studentOnePlus = (Integer.parseInt(studentOneKr)+Integer.parseInt(studentOneEn));
		
		System.out.print("두번째 학생 이름>>");
		String studentTwoName = sc.nextLine();
		student2[0] = studentTwoName;
		System.out.print("두번째 학생 국어점수>>");
		String studentTwoKr = sc.nextLine();
		student2[1] = studentTwoKr;
		System.out.print("두번째 학생 영어점수>>");		
		String studentTwoEn = sc.nextLine();
		student2[2] = studentTwoEn;
		int studentTwoAVG = (Integer.parseInt(studentTwoKr)+Integer.parseInt(studentTwoEn))/2;
		int studentTwoPlus = (Integer.parseInt(studentTwoKr)+Integer.parseInt(studentTwoEn));
		
		System.out.print("세번째 학생 이름>>");
		String studentThreeName = sc.nextLine();
		student3[0] = studentThreeName;
		System.out.print("세번째 학생 국어점수>>");
		String studentThreeKr = sc.nextLine();
		student3[1] = studentThreeKr;
		System.out.print("세번째 학생 영어점수>>");		
		String studentThreeEn = sc.nextLine();
		student3[2] = studentThreeEn;
		int studentThreeAVG = (Integer.parseInt(studentThreeKr)+Integer.parseInt(studentThreeEn))/2;
		int studentThreePlus = (Integer.parseInt(studentThreeKr)+Integer.parseInt(studentThreeEn));
		
		System.out.println("이름	국어	영어 	합계	평균");
		for(int i =0; i<student1.length; i++) {
			System.out.print(student1[i]+"\t");
		}
		System.out.print(studentOnePlus+"\t");
		System.out.print(studentOneAVG);
		System.out.println();
		for(int i =0; i<student1.length; i++) {
			System.out.print(student2[i]+"\t");
		}
		System.out.print(studentTwoPlus+"\t");
		System.out.print(studentTwoAVG);
		System.out.println();
		for(int i =0; i<student1.length; i++) {
			System.out.print(student3[i]+"\t");
		}
		System.out.print(studentThreePlus+"\t");
		System.out.print(studentThreeAVG);
		System.out.println();
		
	}

}
