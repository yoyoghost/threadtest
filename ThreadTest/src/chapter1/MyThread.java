package chapter1;

public class MyThread extends Thread{

	//��дrun����
	@Override
	public void run() {
		super.run();
		System.out.println("MyThread.");
	}
	
}
