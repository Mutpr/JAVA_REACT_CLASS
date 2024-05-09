package week2_0401;

import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, z = 0;
		x = Integer.parseInt(sc.nextLine());
		y = Integer.parseInt(sc.nextLine());
		z = Integer.parseInt(sc.nextLine());
		int [] arr = new int[] {x, y, z};
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
