package week3_0417_thread;

public class Exam02 {

	public static void main(String[] args) {
		Exam02_at exam02_at = new Exam02_at();
		exam02_at.start();
		Exam02_sharp exam02_sharp = new Exam02_sharp();
		exam02_sharp.start();
		for(int i=0; i<100; i++) {
			System.out.print("$");
		}
	}

}
//클래스파일 안에는 여러개의 클래스가 들어갈수는 있는데
//같은 파일안에서 대표 클래스를 하나 정해야 하는데 그것이 접근제한자
/**
 * 스레드를 무분별하게 이용했을때
 * 내 프로그램이 무거운 동작을 취하게됨
 * 운영체제에 대한 스케쥴링 딜레이
 * 스레드를 많이 쓸수록 더 느려짐 (성능저하)
 * 다른 프로세스도 늦게 만들어버림
 * 스레드가 꼭 필요한 경우: 그래픽 프로그램 **/
class Exam02_sharp extends Thread{
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("#");
		}
	}
}

class Exam02_at extends Thread{
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("@");
		}
	}
}
