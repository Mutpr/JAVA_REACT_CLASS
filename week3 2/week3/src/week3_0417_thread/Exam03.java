package week3_0417_thread;

import javax.swing.JOptionPane;

class CountDown extends Thread {
	public static int i =10;
	private String msg = null;
	public CountDown(String msg) {
		this.msg = msg;
	}
	public void run() {
	for(CountDown.i=20; CountDown.i>0; i--){
		System.out.println(i);
		try{Thread.sleep(2000);}
		catch(Exception e){
		}
	}
	System.out.println("GAMEOVER!!!");
	System.exit(0);
	}

}

public class Exam03 {

	public static void main(String[] args) {
		
		String[] sentences = new String[] { "public static void main(String [] args)"
				, "Scanner sc = new Scanner(System.in)", "DataInputStream dis = new DataInputStream()"
		};
		int rand = (int) (Math.random() * 3);
		String msg = JOptionPane.showInputDialog(sentences[rand]);
		if (msg.equals(sentences[rand])) {
			System.out.println("성공!!");
		} else {
			System.out.println("오타!");
		}
		try {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
