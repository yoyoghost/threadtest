package chapter2;

class LockClass {
	
	private String str;
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	synchronized public void m() throws Exception{
		System.out.println("LockClass start...at " + System.currentTimeMillis());
		Thread.sleep(2000);
		System.out.println("LockClass end...at " + System.currentTimeMillis());
	}
	
	public void b() throws Exception{
		synchronized ("aa") {
			System.out.println("LockClass start...at " + System.currentTimeMillis());
			Thread.sleep(2000);
			System.out.println("LockClass end...at " + System.currentTimeMillis());
		}
	}
}

class Locktest {

	// 对象监视器注意static，加与不加的区别
	private static String lock = new String();

	private static String lock2 = new String();

	public void lock() {
		try {
			synchronized (lock) {
				String threadName = Thread.currentThread().getName();
				System.out.println("threadName " + threadName
						+ " lock start at " + System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("threadName " + threadName + " lock end at "
						+ System.currentTimeMillis());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void lock2() {
		try {
			synchronized (lock2) {
				String threadName = Thread.currentThread().getName();
				System.out.println("threadName " + threadName
						+ " lock2 start at " + System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("threadName " + threadName
						+ " lock2 end at " + System.currentTimeMillis());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void lock3() {
		try {
			synchronized (this) {
				String threadName = Thread.currentThread().getName();
				System.out.println("threadName " + threadName
						+ " lock3 start at " + System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("threadName " + threadName
						+ " lock3 end at " + System.currentTimeMillis());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void lock4(LockClass paramLock) {
		try {
			synchronized (paramLock) {
				String threadName = Thread.currentThread().getName();
				System.out.println("threadName " + threadName
						+ " lock4 start at " + System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("threadName " + threadName
						+ " lock4 end at " + System.currentTimeMillis());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class SyncThreadG extends Thread {
	Locktest lt;

	public SyncThreadG(Locktest lt) {
		this.lt = lt;
	}

	@Override
	public void run() {
		lt.lock();
		super.run();
	}
}

class SyncThreadH extends Thread {
	Locktest lt;
	LockClass lc;

	public SyncThreadH(Locktest lt) {
		this.lt = lt;
	}

	public SyncThreadH(Locktest lt, LockClass lc) {
		super();
		this.lt = lt;
		this.lc = lc;
	}

	@Override
	public void run() {
		// lt.lock4(new String("aa"));
		System.out.println("SyncThreadH + "+lc.getStr());
		lt.lock4(lc);
		super.run();
	}
}

class SyncThreadK extends Thread {
	Locktest lt;

	LockClass lc;

	public SyncThreadK(Locktest lt) {
		this.lt = lt;
	}

	public SyncThreadK(Locktest lt, LockClass lc) {
		super();
		this.lt = lt;
		this.lc = lc;
	}

	@Override
	public void run() {
		// lt.lock4(new String("aa"));
		System.out.println("SyncThreadK + "+lc.getStr());
		lt.lock4(lc);
		super.run();
	}
}

public class ObjectLock {
	public static void main(String[] args) throws Exception {
		Locktest lt1 = new Locktest();
		Locktest lt2 = new Locktest();
//		SyncThreadG tg1 = new SyncThreadG(lt1);
//		SyncThreadG tg2 = new SyncThreadG(lt2);
//		tg1.setName("a");
//		tg2.setName("b");
//		tg1.start();
//		Thread.sleep(100);
//		tg2.start();

		final LockClass lc = new LockClass();// 就看锁的对象是不是同一个
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run(){
				try {
					//lc.b();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t.start();
		
		LockClass lc1 = new LockClass();// 就看锁的对象是不是同一个
		lc1.setStr("bbbb");
		SyncThreadH th = new SyncThreadH(lt1, lc1);
		th.setName("c");
		th.start();

		Thread.sleep(100);
		
		lc1.setStr("aaaa");
		SyncThreadK tk = new SyncThreadK(lt2, lc1);
		tk.setName("d");
		tk.start();
	}
}
