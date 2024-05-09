
public class quiz04 {
	public static void main(String[]args) {
		byte b=10;
		char ch = 'A';
		int i = 100;
		long l = 10000L;
		
		b = (byte)i;
		ch = (char)b;
		short s = (short)ch;
		float f = (float) l; //어차피 프로모션 대상임
		i = (int)ch; //프로모션 대상임 
	}
}
