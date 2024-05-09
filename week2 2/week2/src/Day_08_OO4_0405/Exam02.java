package Day_08_OO4_0405;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam02 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Student[] student = new Student[3];
		int code;
		String name;
		int en;
		int math;
		int kr;
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
			student[i] = new Student(code, name, en, kr, math); // Assigning the created Student object to the array
		}

		// TODO Auto-generated method stub

		for (int i = 0; i < student.length; i++) {
			bw.write(student[i].toString()+"\n");
			bw.flush();
		}
		bw.close();
	}

}
