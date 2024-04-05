package week2_0402_method;

public class Ex02 {
	public static void main(String[] args) {
		String str = "Hello";
		int length = strLength(str);
		System.out.println(length);

	}
	
	public static int strLength(String str) {
		int result = str.length();
		return result;
	}
}
