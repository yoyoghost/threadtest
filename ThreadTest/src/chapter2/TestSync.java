package chapter2;

class MyObject {
	synchronized public void methodA() {
		String threadName = Thread.currentThread().getName();
		try {
			System.out.println("threadName = " + threadName + ",A start...atTime = "+System.currentTimeMillis());
			Thread.sleep(3000);
			System.out.println("threadName = " + threadName + ",A end...atTime = "+System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	synchronized public void methodB() {
		String threadName = Thread.currentThread().getName();
		try {
			System.out.println("threadName = " + threadName + ",B start...atTime = "+System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println("threadName = " + threadName + ",B end...atTime = "+System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class SyncThreadA extends Thread {
	MyObject mo;

	public SyncThreadA(MyObject mo) {
		this.mo = mo;
	}

	@Override
	public void run() {
		mo.methodA();
		super.run();
	}
}

class SyncThreadB extends Thread {
	MyObject mo;

	public SyncThreadB(MyObject mo) {
		this.mo = mo;
	}

	@Override
	public void run() {
		mo.methodB();
		super.run();
	}
}

public class TestSync {
	public static void main(String[] args) {
		MyObject mo = new MyObject();
		SyncThreadA a = new SyncThreadA(mo);
		SyncThreadB b = new SyncThreadB(mo);
		a.setName("A");
		b.setName("B");
		a.start();
		b.start();
	}
}
