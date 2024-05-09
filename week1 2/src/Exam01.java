import java.lang.*;
public class Exam01 {
	public static void main(String [] args) {
		Example_Class ex = new Example_Class();
		String arg = ex.example1();
		String a = exampleMethod();
		System.out.println(a);
		System.out.println(arg);
	}
	
	static String exampleMethod() {
		String a1 = "안녕하세요";
		return a1;
	}

}
