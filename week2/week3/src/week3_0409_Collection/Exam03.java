package week3_0409_Collection;

import java.util.ArrayList;

public class Exam03 {

	public static void main(String[] args) {
		ArrayList arr = new ArrayList();
		arr.add("hello");
		arr.add("world");
		arr.add("JAVA");
		
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		
		arr.remove(0);
		
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println(arr.size());
		
	}

}
