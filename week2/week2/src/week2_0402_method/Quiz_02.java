package week2_0402_method;

public class Quiz_02 {

	public static void main(String[] args) {
		String str = "gjofjg;dl;NKDJKLDLKEckldgjkgjdkjlsjkljdklvdsvjJKLJDKLJLKW:JKLJ"
				+"gjdkhgdlkhlwkhflkdfzhfjkHJKWHFJKHEJKFHWEJKHJFHEJKhfgjkrghjrkgr"
				+"gjdkhglkehvlkhLKHFJHFJKHJKFKJEFJEFEJFjkcdjkvcdjkvnj"
				+"FIEHFFKELK;ljlfjkejgfkledvndlkvndvdvdklj"+
				"A";
		int countA = countA(str);
		System.out.println(countA);
	}
	
	public static int countA(String str) {
		int count = 0;
		if(str.contains("A")) {
			count++;
		}
		return count;
	}

}
