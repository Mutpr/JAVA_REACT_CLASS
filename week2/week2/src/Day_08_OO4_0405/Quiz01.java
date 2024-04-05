package Day_08_OO4_0405;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Quiz01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Student[] student = null;
		int code;
		String name;
		int en;
		int math;
		int kr;
		menu: while (true) {
			System.out.println("<<학생 관리 시스템>>");
			System.out.println("1. 신규 입력>>");
			System.out.println("2. 학생 목록 출력>>");
			System.out.println("0. 시스템 종료>>");
			try {
				int menuSelect = Integer.parseInt(bf.readLine());
				switch (menuSelect) {
				case 1:
					System.out.println("입력할 학생의 숫자 입력>>");
					int studentAmountSelect = Integer.parseInt(bf.readLine());
					student = new Student[studentAmountSelect];
					for (int i = 0; i < student.length; i++) {
						System.out.println("학번을 입력하세요:");
						code = Integer.parseInt(bf.readLine());
						System.out.println("이름을 입력하세요.:");
						name = bf.readLine();
						System.out.println("영어점수를 입력하세요.:");
						en = Integer.parseInt(bf.readLine());
						System.out.println("한국어 점수를 입력하세요.:");
						kr = Integer.parseInt(bf.readLine());
						System.out.println("수학 점수를 입력하세요.:");
						math = Integer.parseInt(bf.readLine());
						student[i] = new Student(code, name, en, kr, math);
					}
					continue;
				case 2:
					for (Student studentList : student) {
						bw.write(studentList.toString());
						bw.flush();
					}

					bw.close();
					continue;
				case 0:
					System.out.println("<<시스템을 종료합니다.>>");
					break menu;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
