package chapter2;

public class RunWithTwoObject {
	public static void main(String[] args) {
		PrivateParam pp = new PrivateParam();
		PrivateParam pp1 = new PrivateParam();
		ThreadA ta = new ThreadA(pp);
		ta.start();
		ThreadB tb = new ThreadB(pp1);
		tb.start();
	}
}
