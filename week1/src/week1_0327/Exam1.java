package week1_0327;

public class Exam1 {
	public static void main(String [] args) {
		int num = 10;
		num = 20; // num 변수에저장되어있던 10이 20에 의하여 덮어 씌워진다.
		
		int x = 10;
		int y = 20;
		boolean result;
		int result2;
		result2 = x+y;
		System.out.println(x+"x"+y+"=" + result2);
		x = y = 2;
		System.out.println("x="+ x++ + ", y = " + ++y);
		System.out.println("x=" + x + ",y = "+y);
		y = 10;
		result = !((x>y) || (y==x)|| (x!=y) && (x<y));
		System.out.println(result);
		
		int a = 10;
		int b = 20;
		System.out.println(++a == 10 && b++ == 20);
		System.out.println(a + ":"+ b);
	}
}
