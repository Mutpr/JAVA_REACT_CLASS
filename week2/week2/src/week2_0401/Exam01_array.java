package week2_0401;

public class Exam01_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] arr1 = new char[4];
		arr1[0] = 'A';
		arr1[1] = 'B';
		arr1[2] = 'C';
		arr1[3] = 'D';
		
		for(int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		
		String [] arr2 = new String[]{"Hello", "Java", "Array"};
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		
		int [] arr3 = new int[100];
		for(int i=0; i<arr3.length; i++) {
			arr3[i] = i+1;
			System.out.print(arr3[i]+" ");
		}
		
		char [] arr4 = new char[26];
		for(int i=0; i<arr4.length; i++) {
			arr4[i] = (char) (65+i);
			System.out.println(arr4 [i]+" ");
		}
	}
	

}
