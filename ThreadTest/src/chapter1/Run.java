package chapter1;

public class Run {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		//myThread.start();
		myThread.run();
		//Thread t = new Thread(myThread, "E");
		//t.start();
		//t.run();
	}
}
