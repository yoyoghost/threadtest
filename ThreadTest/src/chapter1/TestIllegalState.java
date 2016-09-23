package chapter1;

class MyThread1 extends Thread{

	@Override
	public void run() {
		try {
			System.out.println("runing.......");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class TestIllegalState{
	public static void main(String[] args) {
		MyThread1 mt = new MyThread1();
		MyThread1 mt1 = new MyThread1();
		mt.start();
		mt1.run();
	}
}
