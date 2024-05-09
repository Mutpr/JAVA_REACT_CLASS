package week2_0402_method;

public class Quiz_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double divide = divide(14, 5);
		System.out.println(divide);
		int bigger = bigger(10, 20);
		System.out.println(bigger);
		int random = myRand(5,17);
		System.out.println(random);
	}
	public static double divide(int a, int b) {
		double result = (double)a/b;
		return result;
	}
	public static int bigger(int a, int b) {
		if(a>b) {
			return a;
		}else if(a<b) {
			return b;
		}else if(a==b) {
			return 0;
		}
		return 0;
	}
	
	public static int myRand(int a, int b) {
		int range = (b-a)+1;
		int result = (int)(range * Math.random())+a;
		return result;
	}

}
