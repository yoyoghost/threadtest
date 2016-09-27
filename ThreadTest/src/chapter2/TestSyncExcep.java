package chapter2;

class ExceptionTest {

	synchronized public void createExcep() {
		String threadName = Thread.currentThread().getName();
		try {
			int i = 10;
			while (i > 0) {
				i--;
				System.out.println("threadName = " + threadName + ", i = " + i);
				Thread.sleep(1000);
				if("a".equals(threadName)&&i==5){
					throw new Exception(threadName + " has an exception..");
					//Integer.parseInt("a");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(threadName + "-b-" + e.getMessage());
		}
	}
}

class SyncThreadE extends Thread {
	ExceptionTest et;

	public SyncThreadE(ExceptionTest et) {
		this.et = et;
	}

	@Override
	public void run() {
		et.createExcep();
		super.run();
	}
}

class SyncThreadF extends Thread {
	ExceptionTest et;

	public SyncThreadF(ExceptionTest et) {
		this.et = et;
	}

	@Override
	public void run() {
		et.createExcep();
		super.run();
	}
}

public class TestSyncExcep {
	public static void main (String[] args) throws Exception{
		ExceptionTest et = new ExceptionTest();
		SyncThreadE se = new SyncThreadE(et);
		SyncThreadF sf = new SyncThreadF(et);
		se.setName("a");
		sf.setName("b");
		se.start();
		Thread.sleep(100);
		sf.start();
	}
}
