package week1_0328;

public class star {
	public static void main(String [] args) {
		for(int i =0; i<13; i++) {
			System.out.print("*");
		}
		System.out.println();
		for(int i=1; i<=13/2; i++) {
			for(int j=0; j<13/2-i+1; j++) System.out.print("*");
			for(int j=0; j<i*2-1; j++) System.out.print(" ");
			for(int j=0; j<13/2-i+1; j++) System.out.print("*");
			System.out.println();
		}
		for(int i =0; i<13; i++) {
			System.out.print("*");
		}
}
}

