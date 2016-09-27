package chapter2;

class Main {
	public int i = 10;

	synchronized public void mainMethod() {
		try {
			i--;
			System.out.println("main print i = " + i);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Sub extends Main {
	synchronized public void subMethod() {
		try {
			while (i > 0) {
				i--;
				System.out.println("sub print i = " + i);
				Thread.sleep(1000);
				this.mainMethod();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class SyncThreadC extends Thread {
	Main m;

	public SyncThreadC(Main m) {
		this.m = m;
	}

	@Override
	public void run() {
		m.mainMethod();
		super.run();
	}
}

class SyncThreadD extends Thread {
	Sub s;

	public SyncThreadD(Sub s) {
		this.s = s;
	}

	@Override
	public void run() {
		s.subMethod();
		super.run();
	}
}

public class TestSyncExtends {
	public static void main(String[] args) {
		Main m = new Main();
		Sub s = new Sub();
		SyncThreadC tc = new SyncThreadC(m);
		SyncThreadD td = new SyncThreadD(s);
		td.start();
		tc.start();
	}
}
