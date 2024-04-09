package week3_0409_Collection;

public class Exam02 {

	public static void main(String[] args) {
		String [] arr = new String[10];
		arr[0] = "hello";
		arr[1] = "world";
		arr[2] = "Java";
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		for(int i=0; i<3; i++) {
			arr[i] = arr[i+1];
			System.out.println(arr[i]);
			
		}
	}
	

}
