package week2_0401;

import java.util.Arrays;

public class Quiz_03 {

	public static void main(String[] args) {
		int [] arr = {15, 24, 35, 99, 86, 34, 13, 27, 46, 66};
		int tmp = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=1; j<arr.length-i; j++) {
				if(arr[j-1]>arr[j]) {
					tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
					System.out.print(Arrays.toString(arr));
				}
			}System.out.println();
		}
	}

}
