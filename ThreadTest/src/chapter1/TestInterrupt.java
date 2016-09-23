package chapter1;

class InterruptThread extends Thread {

	private String tname;

	public InterruptThread(String tname) {
		this.tname = tname;
	}

	@Override
	public void run() {
		try {
			System.out.println(tname + " is runing.......");
			//Thread.sleep(3000);
			for (int i = 0; i < 1000000; i++) {
				Math.random();
			}
			System.out.println(tname + " end.......");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

}

public class TestInterrupt {

	public static void main(String[] args) throws InterruptedException {
		InterruptThread it = new InterruptThread("hello");
		it.start();
		//Thread.sleep(1000);
		it.interrupt();
		System.out.println(it.getTname()+"--interrupted status is "+it.isInterrupted());
		System.out.println(it.getTname()+"--interrupted status is "+it.interrupted());
		System.out.println(it.getTname()+"--interrupted status is "+it.interrupted());
	}
	
//	public static void main(String[] args) {
//		Thread.currentThread().interrupt();
//		System.out.println("interrupted status is "+Thread.interrupted());
//		System.out.println("interrupted status is "+Thread.interrupted());
//		System.out.println("end....");
//	}
	
//	public static void main(String[] args) throws InterruptedException {
//		InterruptThread it = new InterruptThread("hello");
//		it.start();
//		Thread.sleep(1000);
//		it.interrupt();
//		System.out.println(it.getTname()+"--interrupted status is "+it.interrupted());
//		System.out.println(it.getTname()+"--interrupted status is "+it.interrupted());
//		System.out.println(it.getTname()+"--interrupted status is "+it.interrupted());
//	}
}
