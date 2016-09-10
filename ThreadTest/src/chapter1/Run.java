package chapter1;

public class Run {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		System.out.println("Run");
		//会发现Run 是在  MyThread 之前打印出来
	}
}
