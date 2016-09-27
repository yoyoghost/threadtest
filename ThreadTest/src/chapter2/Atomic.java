package chapter2;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicClass extends Thread {
	private AtomicInteger count = new AtomicInteger();

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println(count.incrementAndGet());
		}
	}
}

public class Atomic {
	public static void main(String[] args) {
		AtomicClass ac = new AtomicClass();
		Thread t1 = new Thread(ac);
		t1.start();
		Thread t2 = new Thread(ac);
		t2.start();
		Thread t3 = new Thread(ac);
		t3.start();
		Thread t4 = new Thread(ac);
		t4.start();
	}
}
