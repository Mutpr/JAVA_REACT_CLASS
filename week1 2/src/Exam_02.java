
public class Exam_02 {
	public static void main(String [] args) {
		byte a = 127;//변수 선언
		short b = 32767;
		int d = 2100000000;
		long e = 10000000000L;
		char c = 'A';
		char c1 = 65535;//char 는 어쨌든 문자로 출력되게 되어있는 문자형
		float f = 3.14f;//실수형은 기본적으로 double로 인식되게 되어있어서 float 이용하고 싶으면 뒤에 f를 붙여줘야함
		double g = 5.14; //double은 실수형의 기본 형태여서 굳이 알파벳을 붙일 필요없음
		boolean h = true; //불린은 참 또는 거짓외에는 아무것도 저장할수없음
		String i = "안녕하세요";
		System.out.println(c);
		System.out.println(c1);
		System.out.println('A'+10); //한글자는 겉으로 보기에는 문자여도 실제로는 숫자
		//출력하지 않아서 콘솔에 안 뜨게 됨 하지만 우리 눈엔 보이지 않아도 공간은 만들어짐
	}
}
