package chapter2;

class DeadThread extends Thread {

	public String flag;
	public Object lock1 = new Object();
	public Object lock2 = new Object();

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		if ("a".equals(flag)) {
			synchronized (lock1) {
				try {
					System.out.println("flag = " + flag);
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("lock1>>>>>lock2");
				}
			}
		}
		if ("b".equals(flag)) {
			synchronized (lock2) {
				try {
					System.out.println("flag = " + flag);
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("lock2>>>>>lock1");
				}
			}
		}
	}
}

public class DeadLock {

	public static void main(String[] args) throws Exception {
		DeadThread dt = new DeadThread();

		dt.setFlag("a");
		Thread t1 = new Thread(dt);
		t1.start();

		Thread.sleep(100);

		dt.setFlag("b");
		Thread t2 = new Thread(dt);
		t2.start();
	}

}
