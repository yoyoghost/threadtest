package chapter2;

public class ThreadA extends Thread{

	PrivateParam pp;
	
	public ThreadA(PrivateParam pp) {
		this.pp = pp;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		pp.addNum("a");
	}
	
}
