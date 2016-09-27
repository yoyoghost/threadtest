package chapter2;

public class ThreadB extends Thread{

	PrivateParam pp;
	
	public ThreadB(PrivateParam pp) {
		this.pp = pp;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		pp.addNum("b");
	}
	
}