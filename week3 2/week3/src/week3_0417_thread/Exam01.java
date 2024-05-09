package week3_0417_thread;

class Worker extends Thread {	
	public void run(){
		for(int i=0; i<100; i++) {
			System.out.print(i + " ");
		}
	}
}
public class Exam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Worker worker = new Worker();
		worker.start();
		for(int i=0; i<100; i++) {
			System.out.print(i+ " ");
		}
	}

}
