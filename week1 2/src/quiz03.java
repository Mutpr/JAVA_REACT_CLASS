
public class quiz03 {
	public static void main(String [] args) {
		int one = ThreeOne();
		long two = ThreeTwo();
		String three = ThreeThree();
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
	}
	
	public static int ThreeOne() {
		int a = 1325;
		int b = 9327;
		int answer = (a * b);
		return answer;
	}
	
	public static long ThreeTwo() {
		int a = 5000;
		long b = 10000000000L;
		long answer = a + b;
		return answer;
	}
	
	public static String ThreeThree() {
		char a = 'A';
		char b = 'B';
		String answer = ""+a+b;
		return answer;
		
	}
}