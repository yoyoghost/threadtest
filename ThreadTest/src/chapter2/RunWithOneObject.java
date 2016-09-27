package chapter2;

public class RunWithOneObject {
	public static void main(String[] args) {
		PrivateParam pp = new PrivateParam();
		ThreadA ta = new ThreadA(pp);
		ta.start();
		ThreadB tb = new ThreadB(pp);
		tb.start();
	}
}
